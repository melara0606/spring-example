package org.melara.project.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
  public static final String EXAMPLE_VIEW = "example.html";

  // Primera forma de enviar una vista
  @GetMapping("/exampleString")
  public String helloWorldString()
  {
    return EXAMPLE_VIEW;
  }

  // Segunda forma de enviar una vista
  @GetMapping("/exampleMAV")
  public ModelAndView helloWorldMAV()
  {
    return new ModelAndView(EXAMPLE_VIEW);
  }
}