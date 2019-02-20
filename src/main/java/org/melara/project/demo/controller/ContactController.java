package org.melara.project.demo.controller;

import org.melara.project.demo.contact.ViewContact;
import org.melara.project.demo.model.ContactModel;
import org.melara.project.demo.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/contact")
public class ContactController {

  @Autowired
  @Qualifier("contactService")
  private ContactServiceImpl contactService;

  @GetMapping("/list")
  public String show(Model model)
  {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.addAttribute("username", user.getUsername());
    model.addAttribute("list", contactService.listContactModel());
    return ViewContact.CONTACTS;
  }

  @GetMapping("/cancel")
  public String cancel()
  {
    return "redirect:list";
  }
  
  @PreAuthorize("hasRole('ROLE_USER')")
  @GetMapping("/addcontact")
  public String contactToForm(Model model, @RequestParam(name="id", required=false) int id)
  {
    ContactModel contact = new ContactModel();
    if( id != 0 ){
      contact = contactService.findContactModelById(Long.valueOf(id));
    }
    model.addAttribute("contactModel", contact);
    return ViewContact.CONTACT_VIEW_FORM;
  }

  @PostMapping(value="/addcontact")
  public String addContactSuccess(
    @ModelAttribute(name="contactModel") ContactModel contactModel, 
    Model model  
  ) {
    if(null != contactService.addContact(contactModel)){
      model.addAttribute("result", 1);
    }else{
      model.addAttribute("result", 0);
    }
    return "redirect:list";
  }

  @GetMapping(value="/remove")
  public String removeContact(@RequestParam(name="id", required=false) int id ) {
    contactService.removeContact(Long.valueOf(id));
    return "redirect:list";
  }
}