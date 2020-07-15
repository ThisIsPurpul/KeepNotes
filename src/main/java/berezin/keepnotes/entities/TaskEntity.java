package berezin.keepnotes.entities;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long parentId;
    private String title;
    @Column(columnDefinition="TEXT")
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
        this(null, null, title, "", false, null, null, null);
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

    public void setCtg(CategoryEntity ctg){
        this.ctg = ctg;
    }
    public CategoryEntity getCtg() {
        return ctg;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @DateTimeFormat(pattern="dd.MMM.yyyy HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    @DateTimeFormat(pattern="dd.MMM.yyyy HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }
}



