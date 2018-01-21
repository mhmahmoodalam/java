
package com.ex.crypto;

/**
 * Crypto Constants
 *
 */
public class CryptoConstants {

    /**
     * Holds the bootstrap file name.
     */
    public static final String BOOTSTRAP_FILE_NAME = "bootstrap.pwd";

    /**
     * Holds the catalina base key
     */
    public static final String CATALINA_BASE = "catalina.base";

    public static final String PBE_KEY_CONFIG_FILE_ABS_BOOT = "PBE_KEY_CONFIG_FILE_ABS_BOOT";

    /**
     * Holds the catalina properties
     */
    public static final String CATALINA_PROPERTIES = "catalina.properties";

    /**
     * Holds the bootstarp properties
     */
    public static final String BOOTSTRAP_PROPERTIES = "abs-bootstrap.properties";

    /**
     * Holds secure folder key
     */
    public static final String BOOTSTRAP_FOLDER_KEY = "bootstrap.folder";

    /**
     * Encrypted value will be prefixed with 'enc('
     */
    public static final String ENCRYPTED_VALUE_PREFIX = "enc(";

    /**
     * Encrypted value will end with ')'
     */
    public static final String ENCRYPTED_VALUE_POSTFIX = ")";

    /**
     * Default algorithm for bouncycastle Decryption
     */
    public static final String DEFAULT_ENCRYPTION_ALGORITHM_NAME = "PBEWITHSHA256AND256BITAES-CBC-BC";

    /**
     * Key Name which holds the bouncycastle Algorithm
     */
    public static final String ENCRYPTION_ALGORITHM_KEY = "encryption.algorithm";

    /**
     * Key Name which holds the Bootstrap Master Password
     */
    public static final String BOOTSTRAP_MASTER_PWD_KEY = "encryption.master.password";

}
