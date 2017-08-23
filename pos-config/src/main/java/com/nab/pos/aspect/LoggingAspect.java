package com.nab.pos.aspect;



import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

  private Logger logger = Logger.getLogger(LoggingAspect.class);

  /*
   * http://www.jtech.ua.es/j2ee/publico/spring-2012-13/apendice_AOP-apuntes.html Un pointcut no
   * puede ser cualquier línea arbitraria de código. La versión actual de Spring solo soporta puntos
   * de corte en ejecuciones de métodos de beans
   */
  @Before("execution(* com.nab.pos.core.service.ClientService.addOrUpdate(..))")
  public void logBefore(JoinPoint joinPoint) {

    logger.info("************************************************");
    logger.info("logBefore() is running!");
    logger.info("-->  : " + joinPoint.getSignature().getName());
    logger.info("************************************************");
  }

  @After("execution(* com.nab.pos.core.service.ClientService.addOrUpdate(..))")
  public void logAfter(JoinPoint joinPoint) {

    logger.info("************************************************");
    logger.info("logAfter() is running!");
    logger.info("-->  : " + joinPoint.getSignature().getName());
    logger.info("************************************************");
  }

  @AfterReturning(pointcut = "execution(* com.nab.pos.core.service.ClientService.list(..))",
      returning = "result")
  public void logAfterReturning(JoinPoint joinPoint, Object result) {

    logger.info("logAfterReturning() is running!");
    logger.info("-->  : " + joinPoint.getSignature().getName());
    logger.info("Method returned value is : " + result);
    logger.info("******");

  }

  // @AfterThrowing

}
