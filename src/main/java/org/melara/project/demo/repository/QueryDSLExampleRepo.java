package org.melara.project.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.melara.project.demo.entidad.Course;
import org.melara.project.demo.entidad.QCourse;
import org.springframework.stereotype.Repository;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
  private static final Log LOG = LogFactory.getLog(QueryDSLExampleRepo.class);
  private QCourse qCourse = QCourse.course;

  @PersistenceContext
  private EntityManager em;

  public void findAll()
  {
    
  }
}