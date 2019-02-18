package org.melara.project.demo.repository;

import java.io.Serializable;

import org.melara.project.demo.entidad.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {
  public abstract Contact findById(Long id);
}