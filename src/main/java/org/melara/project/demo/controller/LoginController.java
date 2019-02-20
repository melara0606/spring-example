package org.melara.project.demo.controller;

import org.melara.project.demo.contact.ViewContact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  @GetMapping("/login")
  public ModelAndView showLoginForm(
    @RequestParam(name="error", required=false) String error,
    @RequestParam(name="logout", required= false) String logout
  )
  {
    ModelAndView model = new ModelAndView(ViewContact.LOGIN);
    model.addObject("error", error);
    model.addObject("logout", logout);
    return model;
  }

  @GetMapping({"/loginsuccess", "/"})
  public String loginCheck() {
    return "redirect:/contact/list";
  }
}