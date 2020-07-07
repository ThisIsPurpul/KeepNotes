package berezin.keepnotes.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long parentId;
    private String title;
    private String description;
    private Boolean done;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "ID_F", nullable = false)
    private CategoryEntity ctg;

    public TaskEntity(){
    }

    public TaskEntity(String title) {
        this.title = title;
    }

    public TaskEntity(Long parentId, String title){
        this(null, parentId, title, "", false, null, null, null);

        LocalDateTime currentDataTime = LocalDateTime.now();
        this.createDate = Date.from(currentDataTime.atZone(ZoneId.systemDefault()).toInstant());
        this.updateDate = createDate;
    }

    public TaskEntity(Long id, Long parentId, String title, String description, Boolean done,
                      Date createDate, Date updateDate, Date date){
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.description = description;
        this.done = done;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.date = date;
    }

    public void setId(Long id){ this.id = id; }
    public Long getId(){ return id; }

    public void setParentId(Long parentId){
        this.parentId = parentId;
    }
    public Long getParentId(){
        return parentId;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setDescription(String description) { this.description = description; }
    public String getDescription(){ return description; }

    public void setDone(Boolean done){ this.done = done; }
    public Boolean getDone(){ return done; }

    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }
}



