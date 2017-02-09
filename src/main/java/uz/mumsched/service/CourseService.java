package uz.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.mumsched.dao.CourseDao;
import uz.mumsched.entity.Course;

/**
 * Created by sherxon on 1/27/17.
 */
@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    public Iterable<Course> findAll(){
       return courseDao.findAll();
    }

    public void save(Course course) {
        courseDao.save(course);
    }

    public Course find(Long id) {
        return courseDao.findOne(id);
    }

    public void delete(Long id) {
        courseDao.delete(id);
    }
}
