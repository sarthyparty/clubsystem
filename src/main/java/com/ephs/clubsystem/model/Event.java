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
    private String startdate;
    private String enddate;
    private String club;
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

    public String getEnddate() {
        return enddate;
    }
    public void setEnddate(String enddate) { this.enddate= enddate; }
    public String getStartdate() { return startdate; }
    public void setStartdate(String startdate) {
        this.startdate= startdate;
    }
    @ManyToMany
            @JoinTable(
                    name= "UserEventRelationship",
                    joinColumns = @JoinColumn(name = "userID"),
                    inverseJoinColumns = @JoinColumn(name = "eventID"))

    Set <User> likes;
    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club_;


}

