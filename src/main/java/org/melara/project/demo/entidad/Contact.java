package org.melara.project.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
  // @GeneratedValue(generator="question_generator")
  // @SequenceGenerator(
  //   name="question_generator",
  //   sequenceName = "question_sequence",
  //   initialValue = 1
  // )
  private Long id;

  @Column(name = "firstName")
  private String fistName;
  
  @Column(name = "lastName")
  private String lastName;
  
  @Column(name = "city")
  private String city;

  @Column(name = "telephone")
  private String telephone;

  public Contact() {
  }

  public Contact(long id, String fistName, String lastName, String city, String telephone) {
    this.id = id;
    this.fistName = fistName;
    this.lastName = lastName;
    this.city = city;
    this.telephone = telephone;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFistName() {
    return this.fistName;
  }

  public void setFistName(String fistName) {
    this.fistName = fistName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", fistName='" + getFistName() + "'" + ", lastName='" + getLastName() + "'"
        + ", city='" + getCity() + "'" + ", telephone='" + getTelephone() + "'" + "}";
  }
}