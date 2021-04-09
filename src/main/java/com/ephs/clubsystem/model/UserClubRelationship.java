package com.ephs.clubsystem.model;

import javax.persistence.*;

@Table(name="user_club_relationship", schema = "clubsystem")
@Entity
public class UserClubRelationship {
    @EmbeddedId
    private UserClubKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "clubid")
    private Club club;

    private String fields;
    private boolean isAdmin;


}
