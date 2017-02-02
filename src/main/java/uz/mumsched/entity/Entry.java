package uz.mumsched.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sherxon on 1/26/17.
 */
@Entity
public class Entry extends BaseEntity{

    @Column(unique =true, nullable = false)
    private String uname;

    private Integer mppCount;

    private Integer fppCount;

    private Integer usCount;

    private Integer optCount;


    @OneToMany(fetch = FetchType.EAGER)
    @OrderBy(value = "uname")
    private Set<Block> blocks;

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
