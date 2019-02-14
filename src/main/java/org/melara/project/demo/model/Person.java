package org.melara.project.demo.model;

public class Person {
  private String name;
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