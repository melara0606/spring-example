package org.melara.project.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.melara.project.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

  private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

  public static final String RESULT_VIEW = "result";
  public static final String EXAMPLE_VIEW = "view_form";
  
  @GetMapping("/showForm")
  public ModelAndView showForm()
  {
    // int result = 5 / 0;
    LOGGER.info("INFO TRACE");
    LOGGER.warn("WARNING TRACE");
    LOGGER.error("ERROR TRACE");
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("person", new Person());
    return mav;
  }

  @PostMapping("/addperson")
  public ModelAndView addPerson(@ModelAttribute("person") Person persona)
  {
    LOGGER.info("URL: addperson, model = " + persona);
    ModelAndView mav = new ModelAndView(RESULT_VIEW);
    mav.addObject("persona", persona);
    return mav;
  }

  @GetMapping(value="")
  public RedirectView redirect() {
    return new RedirectView("/example3/showForm");
  }  
}