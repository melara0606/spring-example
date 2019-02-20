package org.melara.project.demo.model;

public class ContactModel {
  private long id;
  private String fistName;
  private String lastName;
  private String city;
  private String telephone;

  public ContactModel() {
  }

  public ContactModel(long id, String fistName, String lastName, String city, String telephone) {
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
    return "{" +
      " id='" + getId() + "'" +
      ", fistName='" + getFistName() + "'" +
      ", lastName='" + getLastName() + "'" +
      ", city='" + getCity() + "'" +
      ", telephone='" + getTelephone() + "'" +
      "}";
  }

}