package uz.mumsched.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by sherxon on 1/26/17.
 */
@Entity
public class Schedule extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
