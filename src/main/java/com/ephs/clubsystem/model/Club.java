package com.ephs.clubsystem.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String template;
    private String defaults;
    private String code;
    @OneToMany(mappedBy = "user")
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

    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }

    public String getDefaults() {
        return defaults;
    }
    public void setDefaults(String defaults) {
        this.defaults = defaults;
    }

    public String getCode() { return code; }
    public void setCode(String code) {this.code = code; }

    @OneToMany(mappedBy = "club_")
    private List<Event> events;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, template);
    }
    @Override
    public String toString() {
        return "Club: {" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", template: '" + template + '\'' +
                '}';
    }

}
