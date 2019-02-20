package org.melara.project.demo.controller;

import java.util.List;

import org.melara.project.demo.model.ContactModel;
import org.melara.project.demo.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestExampleController {

  @Autowired
  @Qualifier("contactService")
  private ContactServiceImpl contactService;

  @GetMapping("/list")
  public ResponseEntity<List<ContactModel>> restChecket() {
    List<ContactModel> listResponse = contactService.listContactModel();
    return new ResponseEntity<List<ContactModel>>(listResponse, HttpStatus.OK);
  }
}