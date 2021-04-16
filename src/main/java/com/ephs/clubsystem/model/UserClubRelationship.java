package com.ephs.clubsystem.model;

import javax.persistence.*;

@Entity
public class UserClubRelationship {
    @EmbeddedId
    private UserClubKey id;

    @ManyToOne
    @MapsId("userid")
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne
    @MapsId("userid")
    @JoinColumn(name = "clubid")
    private Club club;
    private String fields;
    private boolean isAdmin;

    public UserClubRelationship(User user, Club club) {
        this.user = user;
        this.club = club;
    }
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "UserClubRelationship: {" +
                "userid: " + user.getId() +
                ", clubid: '" + club.getId() + '\'' +
                ", isAdmin: '" + isAdmin + '\'' +
                '}';
    }
}
