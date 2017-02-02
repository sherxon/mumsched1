package uz.mumsched.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.mumsched.entity.Student;
import uz.mumsched.service.StudentService;

/**
 * Created by sherxon on 1/25/17.
 */
@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/")
    public Iterable<Student> getList(){
        return studentService.getList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Student save(Student student){
        return studentService.save(student);
    }


}
