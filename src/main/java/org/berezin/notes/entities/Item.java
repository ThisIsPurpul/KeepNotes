package org.berezin.notes.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long tagId;

    private String title;
    private String description;
    private Boolean isActive;
    private Date dueDate;

    public Item() {};

    public Item(Long id, String title, String description, Boolean isActive, Date dueDate, Long tagId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.dueDate = dueDate;
        this.tagId = tagId;
    }

    //Todo: связать айтем и тэг

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
        return dueDate;
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
        this.dueDate = doDate;
    }
    public void setTagIds(Long tagId) {
        this.tagId = tagId;
    }
}
