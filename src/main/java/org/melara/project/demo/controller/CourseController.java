package org.melara.project.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.melara.project.demo.entidad.Course;
import org.melara.project.demo.repository.QueryDSLExampleRepo;
import org.melara.project.demo.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/courses")
public class CourseController {
  private static final String COURSE_VIEW = "courses";
  private static final Log LOG = LogFactory.getLog(CourseController.class);

  @Autowired
  @Qualifier("courseServiceImpl")
  private CourseServiceImpl courseService;

  @Autowired
  @Qualifier("queryDSLExampleRepo")
  private QueryDSLExampleRepo queryDSLExample;

  @GetMapping("/list")
  public ModelAndView listAllCourse()
  {
    queryDSLExample.findAll();
    ModelAndView mav = new ModelAndView(COURSE_VIEW);
    LOG.info("Call: listAllCourse");
    mav.addObject("courses", courseService.listAllCourse());
    mav.addObject("course", new Course());
    return mav;
  }

  @PostMapping("/add")
  public RedirectView addCourses(@ModelAttribute("course") Course course ) {
    LOG.info("Call: addCourses");
    LOG.info("Course = " + course.toString());
    courseService.addCourse(course);
    return new RedirectView("/courses/list");
  }  
}