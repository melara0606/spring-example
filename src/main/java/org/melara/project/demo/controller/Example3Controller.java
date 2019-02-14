package org.melara.project.demo.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.melara.project.demo.component.ExampleComponent;
import org.melara.project.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

  @Autowired
  @Qualifier("exampleComponent")
  private ExampleComponent exampleComponent;
  
  @GetMapping("/showForm")
  public ModelAndView showForm()
  {
    exampleComponent.sayHello();
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("person", new Person());
    return mav;
  }

  @PostMapping("/addperson")
  public ModelAndView addPerson( @Valid @ModelAttribute("person") Person persona, BindingResult bindingResult)
  {
    ModelAndView mav = new ModelAndView();
    if(bindingResult.hasErrors())
    {
      LOGGER.info(bindingResult.getFieldError());
      mav.setViewName(EXAMPLE_VIEW);
    }
    else
    {
      mav.setViewName(RESULT_VIEW);
      mav.addObject("persona", persona);
    }
    return mav;
  }

  @GetMapping(value="")
  public RedirectView redirect() {
    return new RedirectView("/example3/showForm");
  }
}