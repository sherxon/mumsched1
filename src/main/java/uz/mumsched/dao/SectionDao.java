package uz.mumsched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mumsched.entity.Section;

import javax.transaction.Transactional;

/**
 * Created by sherxon on 1/30/17.
 */
@Repository
@Transactional
public interface SectionDao extends JpaRepository<Section, Long>{

    Iterable<Section> findByStudents_Id(Long id);
}
