package com.BoardGameNight.registration.model;

import javax.persistence.*;

@Entity
@Table(name = "user_groups")
public class UserGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;
}
