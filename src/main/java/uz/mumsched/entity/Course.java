package uz.mumsched.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 1/27/17.
 */
@Entity
public class Course extends BaseEntity{

    @Column(nullable = false)
    private String code;

    @Column(nullable = false, unique = true)
    private String uname;

    private String descrip;

    @OneToOne
    private Course pre;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "course_teacher",
               joinColumns = @JoinColumn(name = "teacher_id"),
               inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Teacher> teachers= new HashSet<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUname() {
        return uname;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Course getPre() {
        return pre;
    }

    public void setPre(Course pre) {
        this.pre = pre;
    }
}
