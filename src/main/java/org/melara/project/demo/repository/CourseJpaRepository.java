package org.melara.project.demo.repository;

import java.io.Serializable;

import org.melara.project.demo.entidad.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {
  public abstract Course findByPrice(int price);
  public abstract Course findByPriceAndHours(int price, int hours);
}