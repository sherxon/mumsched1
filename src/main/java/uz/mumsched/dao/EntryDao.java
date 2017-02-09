package uz.mumsched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mumsched.entity.Entry;

import javax.transaction.Transactional;

/**
 * Created by sherxon on 1/30/17.
 */
@Repository
@Transactional
public interface EntryDao extends JpaRepository<Entry, Long>{
    Entry findByScheduleId(Long id);
}
