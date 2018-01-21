package com.ex.capability;

import org.springframework.stereotype.Component;

import com.ex.utility.logging.Logger;


@Component
public class CapabilityValidation {
    /**
     * MessageFormatZero
     */
    private static final String MSG_FORMAT_ZERO = "[{0}]";

    /**
     * MessageFormatZeroOneTwo
     */
    private static final String MSG_FORMAT_ZERO_ONE_TWO = "[{0}] - [{1}] - [{2}]";

    /**
     * pattern to validate email address
     */
    private static final String EMAIL_VALIDATION_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+"
            + ")*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\"
            + "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
            + "\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]"
            + "[0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\"
            + "x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c"
            + "\\x0e-\\x7f])+)\\])";

    /**
     * pattern to validate name
     */
    private static final String NAME_VALIDATION_PATTERN = "(^[^/\\\\\\@#$*%&()!\"=+_:;<>,.?\\[\\]{}|\\^]*$)";

    /**
     * GENERALLOG
     */
    private static final Logger GENERALLOG = Logger
            .getLogger(CapabilityValidation.class);
    
}
