package uz.mumsched.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uz.mumsched.entity.Teacher;
import uz.mumsched.service.TeacherService;

/**
 * Created by sherxon on 1/27/17.
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Teacher create(Teacher teacher){
        teacherService.save(teacher);
        return teacher;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("teacher/list");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Teacher find(@PathVariable Long id){
        return teacherService.find(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable Long id){
         teacherService.delete(id);
    }


    @RequestMapping(value = "/list")
    public Iterable<Teacher> list(){
        return teacherService.findAll();
    }

}
