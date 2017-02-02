package uz.mumsched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.mumsched.entity.Student;

import javax.transaction.Transactional;

/**
 * Created by sherxon on 1/25/17.
 */
@Transactional
@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

     Student findByName(String name);

    @Query("select s from Student s where s.name=:name")
     Student findStudentByName(@Param(value = "name") String name);

    int findByActive(boolean isActive);
}
