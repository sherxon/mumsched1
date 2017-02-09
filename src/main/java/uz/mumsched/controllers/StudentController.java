package uz.mumsched.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.mumsched.CurrentUser;
import uz.mumsched.entity.Entry;
import uz.mumsched.entity.Section;
import uz.mumsched.entity.Student;
import uz.mumsched.service.ScheduleService;
import uz.mumsched.service.StudentService;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 1/25/17.
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Student create(Student student){
        studentService.save(student);
        return student;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("student/list");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student find(@PathVariable Long id){
        return studentService.find(id);
    }

    @RequestMapping(value = "/list")
    public Iterable<Student> getList(){
        return studentService.getList();
    }

    @RequestMapping(value = "/courses")
    public Iterable<Section> getList(Principal principal){
        CurrentUser currentUser= (CurrentUser) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return studentService.getStudentCourses(currentUser);
    }

    @RequestMapping(value = "/sections")
    public Iterable<Section> getStudentCourses(Principal principal){
        CurrentUser currentUser= (CurrentUser) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        Entry entry=currentUser.getStudent().getEntry();
        return scheduleService.getSections(entry);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
    @RequestMapping(value = "/register")
    public Map<String, Boolean> register(@RequestParam(value="list[]") List<Long> list, Principal principal){
        CurrentUser currentUser= (CurrentUser) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        Map<String, Boolean> map=new HashMap<>();
        boolean isSaved=studentService.register(list, currentUser.getStudent().getId());
        map.put("status", isSaved);
        return map;
    }

}
