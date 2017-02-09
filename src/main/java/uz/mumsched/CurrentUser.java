package uz.mumsched;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import uz.mumsched.entity.Student;

/**
 * Created by sherxon on 2/8/17.
 */
public class CurrentUser extends User {

    Student student;

    public CurrentUser(Student student) {
        super(student.getEmail(), student.getEmail(), AuthorityUtils.NO_AUTHORITIES);
        this.student=student;
    }
    public Long getId(){
        return student.getId();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
