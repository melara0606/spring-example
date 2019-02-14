package org.melara.project.demo.controller;

import org.melara.project.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
  public static final String RESULT_VIEW = "result";
  public static final String EXAMPLE_VIEW = "view_form";
  
  @GetMapping("/showForm")
  public ModelAndView showForm()
  {
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("person", new Person());
    return mav;
  }

  @PostMapping("/addperson")
  public ModelAndView addPerson(@ModelAttribute("person") Person persona)
  {
    ModelAndView mav = new ModelAndView(RESULT_VIEW);
    mav.addObject("persona", persona);
    return mav;
  }
}