package com.nab.pos.endpoint.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nab.pos.core.service.HelloService;

@RestController
@RequestMapping("/product")
public class ProductController {

  private Logger logger = Logger.getLogger(ProductController.class);

  @Autowired
  HelloService service;

  @RequestMapping("/hello")
  public String Hello() {
    logger.info("Hello");
    return service.Hello();
  }

}
