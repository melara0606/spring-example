package org.melara.project.demo.service.impl;

import java.util.List;

import org.melara.project.demo.entidad.Course;
import org.melara.project.demo.repository.CourseJpaRepository;
import org.melara.project.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

  @Autowired
  @Qualifier("courseJpaRepository")
  private CourseJpaRepository courseJpaRepository;

  @Override
  public List<Course> listAllCourse() {
    return courseJpaRepository.findAll();
  }

  @Override
  public Course addCourse(Course course) {
    return courseJpaRepository.save(course);
  }

  @Override
  public int removeCourse(Course course) {
    courseJpaRepository.delete(course);
    return 0;
  }

  @Override
  public Course updateCourse(Course course) {
    return courseJpaRepository.save(course);
  }
}