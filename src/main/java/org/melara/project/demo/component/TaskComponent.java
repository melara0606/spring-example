package org.melara.project.demo.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskComponent")
public class TaskComponent {

  private static final Log LOG = LogFactory.getLog(TaskComponent.class);

  @Scheduled(fixedDelay = 5000)
  public void task()
  {
    LOG.info("TASK NAME: " + new Date());
  }
}