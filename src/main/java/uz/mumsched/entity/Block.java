package uz.mumsched.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by sherxon on 1/26/17.
 */
@Entity
public class Block extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String uname;

    @ManyToOne(fetch = FetchType.EAGER)
    private Entry blocks;

    public Entry getBlocks() {
        return blocks;
    }

    public void setBlocks(Entry blocks) {
        this.blocks = blocks;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
