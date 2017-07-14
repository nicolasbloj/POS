package com.nab.pos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.nab.pos.config", "com.nab.pos.endpoint.controller",
    "com.nab.pos.core.service"})
public class POSConfig {


}
