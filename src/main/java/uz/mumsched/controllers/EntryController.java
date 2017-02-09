package uz.mumsched.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uz.mumsched.dao.BlockDao;
import uz.mumsched.entity.Entry;
import uz.mumsched.entity.Section;
import uz.mumsched.service.EntryService;
import uz.mumsched.service.ScheduleService;

import java.util.List;

/**
 * Created by sherxon on 2/2/17.
 */
@RestController
@RequestMapping(value = "/entry")
public class EntryController {

    @Autowired
    EntryService entryService;

    @Autowired
    BlockDao blockDao;

    @Autowired
    ScheduleService scheduleService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Entry> entries(){
       return entryService.entries();
    }

    @RequestMapping(value = "/")
    public ModelAndView list(){
       return new ModelAndView("entry/list");
    }

    @RequestMapping(value = "/find/{id}")
    public Entry get(@PathVariable Long id){
       return entryService.find(id);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        entryService.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Entry create(Entry entry){
        entryService.save(entry);
        return entry;
    }

    @RequestMapping(value = "/generate/{id}")
    List<Section> generate(@PathVariable Long id){
        Entry entry=entryService.find(id);
        return scheduleService.generate(entry);
    }
}
