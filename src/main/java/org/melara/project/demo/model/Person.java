package org.melara.project.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class Person {

  @NonNull
  @Size(max=6, min=2)
  private String name;

  @NonNull
  @Min(18)
  private int age;

  public Person() {
  }

  public Person(String _name, int _age) {
    this.name = _name;
    this.age = _age;
  }

  /**
   * @return String return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return int return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * @param age the age to set
   */
  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString()
  {
    return "Person [name = " + this.name +", age = " + this.age + " ]";
  }
}