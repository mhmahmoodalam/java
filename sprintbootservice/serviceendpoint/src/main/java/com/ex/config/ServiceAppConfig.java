package com.ex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ex.utility.HeadersValidationInterceptor;

/*
 * created 8/5/2016 x75l
 */
/**
 * Class to define the pre-requisite configurations needed for the application
 */
@Configuration
public class ServiceAppConfig extends WebMvcConfigurerAdapter {

  /*
   * This method initiates the Header validations
   * 
   * @param InterceptorRegistry
   * 
   * @see
   * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
   * addInterceptors
   * (org.springframework.web.servlet.config.annotation.InterceptorRegistry)
   */
  @Override
  public void addInterceptors(final InterceptorRegistry registry) {

    registry.addInterceptor(new HeadersValidationInterceptor());
  }

}
