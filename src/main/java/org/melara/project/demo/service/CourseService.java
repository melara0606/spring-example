package org.melara.project.demo.service;

import java.util.List;

import org.melara.project.demo.entidad.Course;

public interface CourseService {
  public abstract List<Course> listAllCourse();
  public abstract Course addCourse(Course course);
  public abstract int removeCourse(Course course);
  public abstract Course updateCourse(Course course); 
}