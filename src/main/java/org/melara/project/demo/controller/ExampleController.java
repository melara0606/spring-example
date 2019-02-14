package org.melara.project.demo.controller;

import org.melara.project.demo.service.impl.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
  public static final String EXAMPLE_VIEW = "example";

  @Autowired
  @Qualifier("exampleService")
  private ExampleServiceImpl exampleService;

  // Primera forma de enviar una vista
  @GetMapping("/exampleString")
  public String helloWorldString(Model model)
  {
    model.addAttribute("persons", exampleService.getListPeople() );
    return EXAMPLE_VIEW;
  }

  // Segunda forma de enviar una vista
  @GetMapping("/exampleMAV")
  public ModelAndView helloWorldMAV()
  {
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("persons", exampleService.getListPeople() );
    return mav;
  }
}