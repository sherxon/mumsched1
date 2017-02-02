package uz.mumsched.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by sherxon on 1/30/17.
 */
@Entity
public class Section extends BaseEntity{

    @Column(unique = false, nullable = false)
    private String uname;

    private Integer capacity=0;

    @JoinColumn(name = "block_id")
    @ManyToOne
    private Block block;

    @JoinColumn(name = "course_id")
    @ManyToOne
    private Course course;

    @JoinColumn(name = "teacher_id")
    @ManyToOne
    private Teacher teacher;

    @JoinColumn(name = "schedule_id")
    @ManyToOne
    private Schedule schedule;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
