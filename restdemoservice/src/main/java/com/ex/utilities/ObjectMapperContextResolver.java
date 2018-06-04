package com.ex.utilities;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Provider
@Component
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public ObjectMapperContextResolver() {
    	 System.out.println("mapper called");
        mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(
            new PascalNamingStrategy()
        );
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}