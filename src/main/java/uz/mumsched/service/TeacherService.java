package uz.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.mumsched.dao.TeacherDao;
import uz.mumsched.entity.Teacher;

/**
 * Created by sherxon on 1/27/17.
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public Iterable<Teacher> findAll(){
        return teacherDao.findAll();
    }

    public Teacher find(Long id) {
       return teacherDao.findOne(id);
    }

    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }
}
