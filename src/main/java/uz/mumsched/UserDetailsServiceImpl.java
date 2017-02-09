package uz.mumsched;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.mumsched.entity.Student;
import uz.mumsched.service.StudentService;

/**
 * Created by sherxon on 2/8/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student =studentService.findByEmail(s);
        return new CurrentUser(student);
    }

}
