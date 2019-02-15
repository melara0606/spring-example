package org.melara.project.demo.component;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.melara.project.demo.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

  @Autowired
  @Qualifier("courseJpaRepository")
  private CourseJpaRepository courseJpaRepository;

  private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
  public void sayHello()
  {
    LOG.info(courseJpaRepository.findByPriceAndHours(25, 12));
  }
}