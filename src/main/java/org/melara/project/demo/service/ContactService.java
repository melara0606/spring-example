package org.melara.project.demo.service;

import java.util.List;

import org.melara.project.demo.entidad.Contact;
import org.melara.project.demo.model.ContactModel;

public interface ContactService {
  public abstract ContactModel addContact(ContactModel contact);
  public abstract List<ContactModel> listContactModel();
  public abstract Contact findContactByid(Long id);
  public abstract ContactModel findContactModelById(Long id);
  public abstract void removeContact(Long id);
}