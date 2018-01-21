
package com.ex.crypto;

/**
 * This bean hold the masterPassword and the algorithm name which is used along
 * with the masterPassword for the decryption of passwords present in properties
 * files.
 * 
 */
public class DecryptionBean {

    /**
     * masterPassword
     */
    private String masterPassword;
    /**
     * algorithm
     */
    private String algorithm;

    /**
     * Overloaded constructor.
     * 
     * @param masterPassword
     *            the master password
     * @param algorithm
     *            used for decryption
     */
    public DecryptionBean(final String masterPassword, final String algorithm) {
        super();
        this.masterPassword = masterPassword;
        this.algorithm = algorithm;
    }

    /**
     * 
     * @return masterPassword String
     */
    public String getMasterPassword() {
        return masterPassword;
    }

    /**
     * 
     * @param masterPassword
     *            String
     */
    public void setMasterPassword(final String masterPassword) {
        this.masterPassword = masterPassword;
    }

    /**
     * 
     * @return algorithm String
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * 
     * @param algorithm
     *            String
     */
    public void setAlgorithm(final String algorithm) {
        this.algorithm = algorithm;
    }

}