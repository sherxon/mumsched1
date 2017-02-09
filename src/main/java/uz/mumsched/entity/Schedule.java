package uz.mumsched.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by sherxon on 1/26/17.
 */
@Entity
public class Schedule extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String uname;

    @OneToOne
    Entry entry;

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
