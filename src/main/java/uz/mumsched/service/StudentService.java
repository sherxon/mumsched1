package uz.mumsched.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.mumsched.dao.StudentDao;
import uz.mumsched.entity.Student;

/**
 * Created by sherxon on 1/25/17.
 */
@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;


    public Iterable<Student> getList() {
        return studentDao.findAll();
    }

    public Student save(Student student) {
       return studentDao.save(student);
    }

    public int activeStudentCount(){
        return studentDao.findByActive(true);
    }
}
