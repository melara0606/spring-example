package org.melara.project.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.melara.project.demo.contact.ViewContact;
import org.melara.project.demo.model.UserCredectial;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  private static final Log LOG = LogFactory.getLog(LoginController.class);

  @GetMapping(value="/")
  public String redirectToLogin() {
    return "redirect:/login";
  }

  @GetMapping("/login")
  public ModelAndView showLoginForm(
    @RequestParam(name="error", required=false) String error,
    @RequestParam(name="logout", required= false) String logout
  )
  {
    ModelAndView model = new ModelAndView(ViewContact.LOGIN);
    model.addObject("error", error);
    model.addObject("logout", logout);
    model.addObject("userCredectial", new UserCredectial());
    return model;
  }

  @PostMapping("/login")
  public String loginCheck(@ModelAttribute(name="userCredectial") UserCredectial userCredectial) {
    LOG.info(userCredectial.toString());
    if(userCredectial.getName().equals("user") && userCredectial.getPassword().equals("user"))
    {
      return "redirect:/contact/list";
    }
    return "redirect:/login?error";
  }
}