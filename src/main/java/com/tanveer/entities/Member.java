package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member extends EntityBase {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "photo_identity")
    private String photoIdentity;
    @OneToOne
    private TeamRole preferredRole;
    @OneToOne(mappedBy = "member")
    private User user;

    @OneToOne(mappedBy = "teamMember")
    private Player player;
    @ManyToOne
    private  Country country;



}
