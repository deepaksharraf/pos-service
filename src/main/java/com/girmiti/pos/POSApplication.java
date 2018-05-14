package com.girmiti.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.girmiti")
@EntityScan(basePackages = "com.girmiti.pos.dao.model")
@EnableJpaRepositories(basePackages="com.girmiti.pos.dao.repository")
@EnableAutoConfiguration
public class POSApplication extends SpringBootServletInitializer {

  private static final Class<POSApplication> applicationClass = POSApplication.class;

  public static void main(String[] args) {
    SpringApplication.run(applicationClass, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(applicationClass);
  }
}
