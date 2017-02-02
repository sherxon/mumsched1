package uz.mumsched.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 1/26/17.
 */
@Entity
public class Teacher extends BaseEntity{

   @JsonProperty(value = "full_name")
    private String fullName;

    @Column(nullable = true)
    private String descrip;

    @ManyToMany(mappedBy = "teachers")
    @JsonBackReference
    Set<Course> courses= new HashSet<>();

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
