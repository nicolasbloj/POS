package com.nab.pos.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerFactory<T> {


  public static Logger getLogger(Class<?> clas) {
    try {
      Logger logger = Logger.getLogger(clas);
      String log4JPropertyFile = "./../../pos/pos-config/src/main/resources/log4j.properties";
      Properties p = new Properties();
      p.load(new FileInputStream(log4JPropertyFile));
      PropertyConfigurator.configure(p);

      return logger;
    } catch (IOException e) {
    }

    return null;
  }
}
