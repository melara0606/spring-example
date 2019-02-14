package org.melara.project.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
  public static final String ISE_template = "error/500";
  private static final Log log = LogFactory.getLog(ErrorController.class);

  @ExceptionHandler(Exception.class)
  public String InternalErrorServidor(HttpServletRequest req, Exception e)
  {
    log.error("Error: " + e.getMessage());
    return ISE_template;
  }
}