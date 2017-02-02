package uz.mumsched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.mumsched.entity.Teacher;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sherxon on 1/27/17.
 */
@Repository
@Transactional
public interface TeacherDao extends JpaRepository<Teacher, Long>{

    @Query("select t from Teacher t left join fetch t.courses")
    List<Teacher> findAll2();
}
