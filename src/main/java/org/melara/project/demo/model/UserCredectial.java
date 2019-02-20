package org.melara.project.demo.model;

public class UserCredectial {
  private String name;
  private String password;

  public UserCredectial() {
  }

  public UserCredectial(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", password='" + getPassword() + "'" +
      "}";
  }
}