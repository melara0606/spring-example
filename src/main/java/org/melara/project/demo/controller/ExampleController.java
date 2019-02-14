package org.melara.project.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.melara.project.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
  public static final String EXAMPLE_VIEW = "example.html";

  // Primera forma de enviar una vista
  @GetMapping("/exampleString")
  public String helloWorldString(Model model)
  {
    model.addAttribute("persons", getListPeople() );
    return EXAMPLE_VIEW;
  }

  // Segunda forma de enviar una vista
  @GetMapping("/exampleMAV")
  public ModelAndView helloWorldMAV()
  {
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("persons", getListPeople() );
    return mav;
  }

  private List<Person> getListPeople()
  {
    List<Person> list = new ArrayList<>();
    list.add(new Person("Edwin", 26));
    list.add(new Person("Juan", 15));
    list.add(new Person("Antonio", 23));
    list.add(new Person("Eva", 35));
    list.add(new Person("Rodolfo", 12));

    return list;
  }
}