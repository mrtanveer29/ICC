package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends EntityBase {
    @Column(name = "username", unique = true, nullable = false)
    private String userName;
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne
    private Member member;
    @Column(name = "is_active")
    private boolean isActive;
    @ManyToMany
    private List<Role> roles;
}
