package org.melara.project.demo.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logs")
public class Log {
  @Id
  @GeneratedValue
  @Column(name="id")
  private int id;

  @Column(name="date")
  private Date date;
  @Column(name="details")
  private String details;
  @Column(name="username")
  private String username;
  @Column(name="url")
  private String url;


  public Log() {
  }

  public Log(Date date, String details, String username, String url) {
    this.date = date;
    this.details = details;
    this.username = username;
    this.url = url;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDetails() {
    return this.details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", date='" + getDate() + "'" +
      ", details='" + getDetails() + "'" +
      ", username='" + getUsername() + "'" +
      ", url='" + getUrl() + "'" +
      "}";
  }
}