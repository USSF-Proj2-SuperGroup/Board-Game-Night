package com.BoardGameNight.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(exclude = {"userGroup","groupU"})
@Table(name = "user_groups")
public class UserGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("userGroup")
    User userGroup;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group groupU;

    public String getName(){
        return groupU.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(User userGroup) {
        this.userGroup = userGroup;
    }

    public Group getGroupU() {
        return groupU;
    }

    public void setGroupU(Group groupU) {
        this.groupU = groupU;
    }
}
