
package com.ex.crypto;

import static com.ex.crypto.CryptoConstants.BOOTSTRAP_MASTER_PWD_KEY;
import static com.ex.crypto.CryptoConstants.DEFAULT_ENCRYPTION_ALGORITHM_NAME;
import static com.ex.crypto.CryptoConstants.ENCRYPTION_ALGORITHM_KEY;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.ex.utility.logging.Logger;

/**
 * This class is used to read the master password from bootstrap.pwd file which
 * is present in the secure folder. The path to this file is taken from
 * catalina.properties. If it is not specified relative path is taken.
 * 
 */
public class PasswordExtractor {

    /**
     * GENERALLOG
     */
    private static final Logger GENERALLOG = Logger
            .getLogger(PasswordExtractor.class);

    /**
     * Gets the password from "bootstrap.pwd" file.
     * 
     * @return String password as String
     * @throws IOException
     *             IOException
     */
    public static DecryptionBean getDecryptionProperties() throws IOException {

        DecryptionBean decryptionBean = null;
        InputStream inputStream = null;
        try {

            GENERALLOG.info("getenv: CONFIG_FILE_ABS_BOOT");
            final String secureFilelocation = System
                    .getenv("PBE_KEY_CONFIG_FILE_ABS_BOOT");
            // bootstrap.properties File object
            GENERALLOG.info("creating new File: " + secureFilelocation);
            final File secureFile = new File(secureFilelocation);
            inputStream = new FileInputStream(secureFile);
            final Properties prop = new Properties();
            prop.load(inputStream);
            // Getting the values from the bootstrap properties file
            final String masterPassword = prop
                    .getProperty(BOOTSTRAP_MASTER_PWD_KEY);
            GENERALLOG.info("MASTER_PASSWORD: " + masterPassword);
            String algorithm = prop.getProperty(ENCRYPTION_ALGORITHM_KEY);
            GENERALLOG.info("ENCRYPTION_ALGORITHM_KEY: " + algorithm);

            // If blank, take the default algorithm
            if (isBlank(algorithm)) {
                algorithm = DEFAULT_ENCRYPTION_ALGORITHM_NAME;
                GENERALLOG.info(
                        "algorithm was blank, using default: " + algorithm);
            }
            // Get the decryption parameters - master password, algorithm name
            // and provider name
            decryptionBean = new DecryptionBean(masterPassword, algorithm);

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return decryptionBean;
    }

    /**
     * 
     * @param algorithm
     *            String
     * @return passwordEncryptor StandardPBEStringEncryptor
     */
    public static StandardPBEStringEncryptor getEncryptor(
            final String algorithm) {
        final StandardPBEStringEncryptor passwordEncryptor = new StandardPBEStringEncryptor();
        passwordEncryptor.setAlgorithm(algorithm);
        return passwordEncryptor;
    }
}