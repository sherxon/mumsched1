package uz.mumsched.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uz.mumsched.entity.Section;
import uz.mumsched.service.ScheduleService;

import java.util.List;

/**
 * Created by sherxon on 1/30/17.
 */
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
    public void create(@PathVariable Long id){
        scheduleService.save(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("schedule/list");
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public List<Section> index(@PathVariable Long id){
        return scheduleService.getSections(id);
    }
}
