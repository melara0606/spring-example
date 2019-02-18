package org.melara.project.demo.configuration;

import org.melara.project.demo.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
  @Autowired
  @Qualifier("requestTimeInterceptor")
  RequestTimeInterceptor requestTimeInterceptor;

  public void addInterceptors(InterceptorRegistry registry)
  {
    registry.addInterceptor(requestTimeInterceptor);
  }
}