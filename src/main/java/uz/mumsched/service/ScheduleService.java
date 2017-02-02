package uz.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.mumsched.dao.CourseDao;
import uz.mumsched.dao.EntryDao;
import uz.mumsched.dao.ScheduleDao;
import uz.mumsched.dao.SectionDao;
import uz.mumsched.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/30/17.
 */
@Service
public class ScheduleService {

    @Autowired
    SectionDao sectionDao;

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    EntryDao entryDao;

    @Autowired
    StudentService studentService;

    private static int CAPACITY=25;

    public List<Section> generate(Entry entry){
        List<Section> list=new ArrayList<>();
        List<Block> blocks=new ArrayList<>(entry.getBlocks());
        int activeStudentCount=studentService.activeStudentCount();
        Schedule schedule= new Schedule();
        Course mpp=courseDao.findByCode("MPP400");
        Course fpp=courseDao.findByCode("FPP300");
        List<Teacher> mppTeachers=new ArrayList<>(mpp.getTeachers());
        List<Teacher> fppTeachers=new ArrayList<>(fpp.getTeachers());
        for (int i = 0; i <blocks.size(); i++) {
            if(i==0){
                int mppClazz=entry.getMppCount() / CAPACITY;
                if(entry.getMppCount() % CAPACITY > CAPACITY/2)
                    mppClazz++;
                int fppClazz=entry.getFppCount() / CAPACITY;
                if(entry.getFppCount() % CAPACITY > CAPACITY/2)
                    fppClazz++;
                for (int j = 0; j < mppClazz; j++) {
                    Section section= new Section();
                    section.setBlock(blocks.get(i));
                    section.setCapacity(25);
                    section.setCourse(mpp);
                    section.setSchedule(schedule);
                    section.setUname(String.valueOf((char) (j+65)));
                    if(j<mpp.getTeachers().size()) {
                        section.setTeacher(mppTeachers.get(j));
                    }
                    list.add(section);
                }
                for (int j = 0; j < fppClazz; j++) {
                    Section section= new Section();
                    section.setBlock(blocks.get(i));
                    section.setCapacity(25);
                    section.setCourse(fpp);
                    section.setSchedule(schedule);
                    section.setUname(String.valueOf((char) (j+65)));
                    if(j<fpp.getTeachers().size())
                    section.setTeacher(fppTeachers.get(j));
                    list.add(section);
                }
            }else if (i==1){
                int fppClazz=entry.getFppCount() / CAPACITY;
                if(entry.getFppCount() % CAPACITY > CAPACITY/2)
                    fppClazz++;
                for (int j = 0; j < fppClazz; j++) {
                    Section section= new Section();
                    section.setBlock(blocks.get(i));
                    section.setCapacity(25);
                    section.setCourse(mpp);
                    section.setSchedule(schedule);
                    section.setUname(String.valueOf((char) (j+65)));
                    if(j<mpp.getTeachers().size())
                        section.setTeacher(mppTeachers.get(j));
                    list.add(section);
                }
                int mppClazz=entry.getMppCount() / CAPACITY;
                if(entry.getMppCount() % CAPACITY > CAPACITY/2)
                    mppClazz++;
                List<Course> courses=courseDao.findAll();
                for (int j = 0; j < mppClazz; j++) {
                    Course course=courses.get(j);
                    Section section= new Section();
                    section.setBlock(blocks.get(i));
                    section.setCapacity(25);
                    section.setCourse(course);
                    section.setSchedule(schedule);
                    section.setUname(String.valueOf((char) (j + 65)));
                    if(j<course.getTeachers().size()){
                        List<Teacher> courseT= new ArrayList<>(course.getTeachers());
                        section.setTeacher(courseT.get(j));
                    }

                    list.add(section);
                }
            }else{
                int all=entry.getFppCount()+entry.getMppCount();
                int clazz=all/CAPACITY;
                if(all%CAPACITY > CAPACITY/2)clazz++;
                List<Course> courses=courseDao.findAll();
                for (int j = 0; j < clazz; j++) {
                    Course course=courses.get(j);
                    Section section= new Section();
                    section.setBlock(blocks.get(i));
                    section.setCapacity(25);
                    section.setCourse(course);
                    section.setSchedule(schedule);
                    section.setUname(String.valueOf((char) (j + 65)));
                    if(j<course.getTeachers().size()) {
                        List<Teacher> courseT= new ArrayList<>(course.getTeachers());
                        section.setTeacher(courseT.get(j));
                    }
                    list.add(section);
                }
            }

        }


        return list;
    }


}
