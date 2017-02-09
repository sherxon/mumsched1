package uz.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.mumsched.dao.EntryDao;
import uz.mumsched.entity.Entry;

/**
 * Created by sherxon on 2/2/17.
 */
@Service
public class EntryService {

    @Autowired
    EntryDao entryDao;

    public Iterable<Entry> entries(){
        return entryDao.findAll();
    }

    public void save(Entry entry) {
        entryDao.save(entry);
    }

    public Entry find(Long id) {
        return entryDao.getOne(id);
    }

    public void delete(Long id) {
         entryDao.delete(id);
    }
}
