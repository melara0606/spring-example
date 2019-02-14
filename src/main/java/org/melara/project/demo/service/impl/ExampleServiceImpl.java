package org.melara.project.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.melara.project.demo.model.Person;
import org.melara.project.demo.service.ExampleService;
import org.springframework.stereotype.Service;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

  private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

  @Override
  public List<Person> getListPeople() {
    List<Person> list = new ArrayList<>();
    list.add(new Person("Edwin", 26));
    list.add(new Person("Juan", 15));
    list.add(new Person("Antonio", 23));
    list.add(new Person("Eva", 35));
    list.add(new Person("Rodolfo", 12));
    LOG.info("HELLO SERVICE IMPLEMENTATION");
    return list;
  }
}