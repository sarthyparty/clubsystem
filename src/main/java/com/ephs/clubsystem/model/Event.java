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
    @ManyToMany
            @JoinTable(
                    name= "UserEventRelationship",
                    joinColumns = @JoinColumn(name = "userID"),
                    inverseJoinColumns = @JoinColumn(name = "eventID"))

    Set <User> likes;



}

