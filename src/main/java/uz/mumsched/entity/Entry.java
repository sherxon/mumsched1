package uz.mumsched.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 1/26/17.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Entry extends BaseEntity{

    @Column(unique =true, nullable = false)
    private String uname;

    private Integer mppCount;

    private Integer fppCount;

    private Integer usCount;

    private Integer optCount;

    @OneToOne
    private Schedule schedule;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "entry")
    @OrderBy(value = "uname")
    @JsonBackReference
    private Set<Block> blocks= new HashSet<>();

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getMppCount() {
        return mppCount;
    }

    public void setMppCount(Integer mppCount) {
        this.mppCount = mppCount;
    }

    public Integer getFppCount() {
        return fppCount;
    }

    public void setFppCount(Integer fppCount) {
        this.fppCount = fppCount;
    }

    public Integer getUsCount() {
        return usCount;
    }

    public void setUsCount(Integer usCount) {
        this.usCount = usCount;
    }

    public Integer getOptCount() {
        return optCount;
    }

    public void setOptCount(Integer optCount) {
        this.optCount = optCount;
    }

    public Set<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(Set<Block> blocks) {
        this.blocks = blocks;
    }
}
