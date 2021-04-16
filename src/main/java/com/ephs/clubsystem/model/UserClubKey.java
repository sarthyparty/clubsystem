package com.ephs.clubsystem.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserClubKey implements Serializable {
    @Column(name = "userid")
    private Long userid;

    @Column(name = "clubid")
    private Long clubid;
}
