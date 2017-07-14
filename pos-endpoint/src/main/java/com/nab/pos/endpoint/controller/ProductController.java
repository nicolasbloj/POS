package com.nab.pos.endpoint.controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

  private Logger logger = Logger.getLogger(ProductController.class);

  @RequestMapping("/hello")
  public String Hello() {
    logger.info("Hello");
    return "HelloWorld";
  }

}
