package uz.mumsched.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 1/26/17.
 */
@Entity
public class Block extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String uname;


    private String startDate;

    private String endDate;

    @OneToMany(mappedBy ="block")
    @JsonBackReference
    private Set<Section> sections= new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Entry entry;

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

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
