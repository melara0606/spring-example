package org.melara.project.demo.service.impl;

import java.util.List;

import org.melara.project.demo.component.ContactConvert;
import org.melara.project.demo.entidad.Contact;
import org.melara.project.demo.model.ContactModel;
import org.melara.project.demo.repository.ContactRepository;
import org.melara.project.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

  @Autowired
  @Qualifier("contactRepository")
  private ContactRepository contactRepository;

  @Autowired
  @Qualifier("contactConvert")
  private ContactConvert contactConvert;

  @Override
  public ContactModel addContact(ContactModel contact) {
    Contact c = contactRepository.save(contactConvert.contactModel2Contact(contact));
    return contactConvert.contact2ContactModel(c);
  }

  @Override
  public List<ContactModel> listContactModel() {
    return contactConvert.contactList2ContactModelList(contactRepository.findAll());
  }

  @Override
  public Contact findContactByid(Long id) {
    return contactRepository.findById(id);
  }

  @Override
  public void removeContact(Long id) {
    Contact contact = findContactByid(id);
    if(null != contact){
      contactRepository.delete(contact);
    }
  }

  @Override
  public ContactModel findContactModelById(Long id) {
    return contactConvert.contact2ContactModel(contactRepository.findById(id));
  }
}