package uz.mumsched.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by sherxon on 1/25/17.
 */
@Entity
public class Student extends BaseEntity{

    private String name;

    @Column(nullable = true)
    private boolean active=false;

    public Student() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
