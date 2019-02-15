package org.melara.project.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

  //@GeneratedValue(strategy=GenerationType.AUTO) 

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private long id;
  @Column(name="name")
  private String name;
  @Column(name="description")
  private String description;
  @Column(name="price")
  private int price;
  @Column(name="hours")
  private int hours;

  public Course() {
  }

  public Course(long id, String name, String description, int price, int hours) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.hours = hours;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getHours() {
    return this.hours;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }  

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", description='" + getDescription() + "'" +
      ", price='" + getPrice() + "'" +
      ", hours='" + getHours() + "'" +
      "}";
  }
}