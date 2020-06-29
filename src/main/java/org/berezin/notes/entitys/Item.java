package org.berezin.notes.entitys;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long tagId;

    private String title;
    private String description;
    private Boolean isActive;
    private Date doDate;

    public Item() {};

    public Item(String title, String description, Boolean isActive, Date doDate, Long tagId) {
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.doDate = doDate;
        this.tagId = tagId;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Boolean getActive() {
        return isActive;
    }
    public Date getDoDate() {
        return doDate;
    }
    public Long getTagIds() {
        return tagId;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setActive(Boolean isActive){
        this.isActive = isActive;
    }
    public void setDoDate(Date doDate) {
        this.doDate = doDate;
    }
    public void setTagIds(Long tagId) {
        this.tagId = tagId;
    }
}
