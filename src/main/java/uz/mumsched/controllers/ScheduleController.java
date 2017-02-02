package uz.mumsched.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uz.mumsched.entity.Section;
import uz.mumsched.service.ScheduleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/30/17.
 */
@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;


    List<Section> generate(){
        return new ArrayList<>();
    }
}
