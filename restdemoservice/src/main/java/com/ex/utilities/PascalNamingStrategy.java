package com.ex.utilities;

import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.springframework.stereotype.Component;

/**
 * @author
 *
 */
public class PascalNamingStrategy extends PropertyNamingStrategy {

	 Logger logger = Logger.getLogger(PascalNamingStrategy.class);
    @Override
    public String nameForGetterMethod(final MapperConfig<?> config,
            final AnnotatedMethod method, final String defaultName) {
    		
        final String camelCaseName = getPascalCase(defaultName);
        return camelCaseName;
    }

    /**
     * Method to change the name from camelCase to PascalCase
     * 
     * @param defaultName
     *            String
     * @return camelCaseName
     */
    private String getPascalCase(final String defaultName) {
        final int defaultNameLength = defaultName.length();
        final String firstCharacter = defaultName.substring(0, 1);
        final String camelCaseName = firstCharacter.toUpperCase()
                .concat(defaultName.substring(1, defaultNameLength));
        return camelCaseName;

    }

}