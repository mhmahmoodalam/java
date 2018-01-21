package com.ex.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ex.exception.ApplicationServiceException;

import sun.misc.BASE64Encoder;

/**
 *
 */
@SuppressWarnings("restriction")
public class SecurityUtility {
    private static final Logger GENERAL_LOG = LogManager
            .getLogger(SecurityUtility.class);

    private final String bstAlias;
    private final String keyStore;
    private final String keyStorePassword;

    /**
     * constructor This method sets the security certificates before calling the
     * external services over secure protocol
     * 
     * @param sslStore
     *            String
     * @param sslPassword
     *            String
     * @param bstAlias
     *            String
     */
    public SecurityUtility(final String sslStore, final String sslPassword,
            final String bstAlias) {
        this.keyStore = sslStore;
        this.keyStorePassword = sslPassword;
        this.bstAlias = bstAlias;
        System.setProperty("javax.net.ssl.keyStore", sslStore);
        System.setProperty("javax.net.ssl.keyStorePassword", sslPassword);
        System.setProperty("javax.net.ssl.keyStoreType",
                "ConstantsUtility.KEYSTORE_TYPE");
        System.setProperty("javax.net.ssl.trustStore", sslStore);
        System.setProperty("javax.net.ssl.trustStorePassword", sslPassword);
        System.setProperty("javax.net.ssl.trustStoreType",
                "ConstantsUtility.KEYSTORE_TYPE");
        System.setProperty("java.protocol.handler.pkgs",
                "com.sun.net.ssl.internal.www.protocol");
    }

    /**
     * @return the bstAlias
     */
    public String getBstAlias() {
        return bstAlias;
    }

    /**
     * @return the keyStore
     */
    public String getKeyStore() {
        return keyStore;
    }

    /**
     * @return the keyStorePassword
     */
    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    /**
     * Read certificate X509 and encoded into Base 64.
     * 
     * @return String
     * @throws ServiceException
     *             ServiceException
     */
    public String readBSTFromkeystore() throws ApplicationServiceException {
        String psB64Certificate = null;
        InputStream inStream = null;
        try {
            // Reading the certificate X509 and encoded into Base 64.
            inStream = new FileInputStream(this.getKeyStore());
            final KeyStore keystore = KeyStore
                    .getInstance(KeyStore.getDefaultType());
            keystore.load(inStream, this.getKeyStorePassword().toCharArray());
            final Certificate bstcertificate = keystore
                    .getCertificate(this.getBstAlias());

            final BASE64Encoder encoder = new BASE64Encoder();
            psB64Certificate = encoder
                    .encodeBuffer(bstcertificate.getEncoded());
            psB64Certificate = psB64Certificate.replaceAll(
                   " ConstantsUtility.NEW_LINE_CHAR",
                    "ConstantsUtility.EMPTY_SPACE");
            psB64Certificate = psB64Certificate.replaceAll(
                    "ConstantsUtility.CARRIAGE_RETRUN_FEED",
                    "ConstantsUtility.EMPTY_SPACE");
            inStream.close();
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException
                | CertificateException e) {
            final String message = "Failed while building Security Header. Rethrowing original exception: [{0}]";
            GENERAL_LOG.error(message, e.getMessage());
            throw new ApplicationServiceException(
                    "Exception occurred while building Security Header" + e);
        } finally {
            if (null != inStream) {
                inStream = null;
            }
        }
        return psB64Certificate;
    }

}
