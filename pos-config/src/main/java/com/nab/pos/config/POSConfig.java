package com.nab.pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.nab.pos.aspect.LoggingAspect;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.nab.pos.config", "com.nab.pos.endpoint.controller",
    "com.nab.pos.core", "com.nab.pos.repository"})
@EnableAspectJAutoProxy
public class POSConfig {

  @Bean
  public LoggingAspect loggingAspect() {
    return new LoggingAspect();
  }

}
