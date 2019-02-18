package org.melara.project.demo.component;

import java.util.ArrayList;
import java.util.List;

import org.melara.project.demo.entidad.Contact;
import org.melara.project.demo.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConvert")
public class ContactConvert {
  public Contact contactModel2Contact(ContactModel contactModel){
    return new Contact(
      contactModel.getId(), contactModel.getFistName(),
      contactModel.getLastName(), contactModel.getCity(),
      contactModel.getTelephone()
    );
  }

  public ContactModel contact2ContactModel ( Contact contact )
  {
    return new ContactModel(
      contact.getId(), contact.getFistName(), contact.getLastName(),
      contact.getCity(), contact.getTelephone()
    );
  }

  public List<ContactModel> contactList2ContactModelList( List<Contact> list ) {
    List<ContactModel> listReturn = new ArrayList<ContactModel>();
    for (Contact item : list) {
      listReturn.add(contact2ContactModel(item));
    }
    return listReturn;
  }
}