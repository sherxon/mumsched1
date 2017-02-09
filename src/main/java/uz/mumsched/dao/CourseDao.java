package uz.mumsched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mumsched.entity.Course;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * Created by sherxon on 1/27/17.
 */
@Repository
@Transactional
public interface CourseDao extends JpaRepository<Course, Long> {

    Course findByCode(String mpp400);

    List<Course> findByCodeNotIn(Collection<String> basics);

}
