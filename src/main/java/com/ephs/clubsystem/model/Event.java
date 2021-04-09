package com.ephs.clubsystem.model;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String club;
    @Basic
    private java.sql.Timestamp startdate;
    @Basic
    private java.sql.Timestamp enddate;
    public long getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) { this.description = description; }

    public java.sql.Timestamp getEnddate() {
        return enddate;
    }
    public void setEnddate(String enddate) { this.enddate=java.sql.Timestamp.valueOf(enddate);}
    public java.sql.Timestamp getStartdate() { return startdate; }
    public void setStartdate(String startdate) {
        this.startdate=java.sql.Timestamp.valueOf(startdate);
    }


    @ManyToMany
            @JoinTable(
                    name= "UserEventRelationship",
                    joinColumns = @JoinColumn(name = "userID"),
                    inverseJoinColumns = @JoinColumn(name = "eventID"))

    Set <User> users;
    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club_;


}

