package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends EntityBase {
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
