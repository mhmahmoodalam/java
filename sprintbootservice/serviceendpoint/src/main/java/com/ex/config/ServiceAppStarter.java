package com.ex.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/*
 * created 8/5/2016 x75l
 */
/**
 * Class to initiate Application.
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ImportResource("classpath:spring-config.xml")
public class ServiceAppStarter extends SpringBootServletInitializer {

  private static final Logger GENERAL_LOG = LogManager
  .getLogger(ServiceAppStarter.class);

  /*
   * Configure APP properties
   * 
   * @param SpringApplicationBuilder
   * 
   * @see
   * org.springframework.boot.web.support.SpringBootServletInitializer#configure
   * (org.springframework.boot.builder.SpringApplicationBuilder)
   */
  @Override
  protected SpringApplicationBuilder configure(
  final SpringApplicationBuilder application) {
    return application.sources(ServiceAppStarter.class);
  }

  /**
   * This is the starter method for the application
   * 
   * @param args
   *          args
   */
  public static void main(String[] args) {
    GENERAL_LOG.info("Starting Service App");

    SpringApplication.run(ServiceAppStarter.class, args);
  }

}
