package uz.mumsched.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.mumsched.CurrentUser;
import uz.mumsched.dao.SectionDao;
import uz.mumsched.dao.StudentDao;
import uz.mumsched.entity.Section;
import uz.mumsched.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 1/25/17.
 */
@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    SectionDao sectionDao;

    public Iterable<Student> getList() {
        return studentDao.findAll();
    }

    public Student save(Student student) {
       return studentDao.save(student);
    }

    public Student find(Long id) {
       return studentDao.findOne(id);
    }

    public void delete(Long id) {
        studentDao.delete(id);
    }

    public Student findByEmail(String s) {
       return studentDao.findByEmail(s);
    }

    public Iterable<Section> getStudentCourses(CurrentUser currentUser) {
       return sectionDao.findByStudents_Id(currentUser.getId());
    }

    public boolean register(List<Long> sections, Long studentId) {
        Student student = studentDao.getOne(studentId);
        Map<String, Section> map=new HashMap<>();
        for (Long sectionId : sections) {
            Section section = sectionDao.findOne(sectionId);
            if(map.containsKey(section.getBlock().getUname()))return false;
            map.put(section.getBlock().getUname(), section);
        }
        if(map.size() < student.getEntry().getBlocks().size())return false;
        student.getSections().clear();
        studentDao.save(student);
        for (String s : map.keySet()) {
            student.getSections().add(map.get(s));
        }
        studentDao.save(student);
        return true;
    }
}
