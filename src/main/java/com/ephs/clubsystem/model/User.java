package com.ephs.clubsystem.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "club")
    private Set<UserClubRelationship> userClubRelationships;

    public long getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }
    @Override
    public String toString() {
        return "Student: {" +
                "id: " + id+
                ", email: '" + email + '\'' +
                ", password: '" + password + '\'' +
                '}';
    }
    @ManyToMany(mappedBy = "likes")
    Set<Event> likedEvents;


}
