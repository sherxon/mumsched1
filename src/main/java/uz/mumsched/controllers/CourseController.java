package uz.mumsched.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uz.mumsched.entity.Course;
import uz.mumsched.service.CourseService;

/**
 * Created by sherxon on 1/27/17.
 */
@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Course create(Course course){
        courseService.save(course);
        return course;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Course find(@PathVariable Long id){
        return courseService.find(id);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable Long id){
         courseService.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(){
        return new ModelAndView("course/create");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("course/list");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Course> list(){
        return courseService.findAll();
    }
}
