package com.ephs.clubsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String template;

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
    public void setEmail(String template) {
        this.template = template;
    }

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
