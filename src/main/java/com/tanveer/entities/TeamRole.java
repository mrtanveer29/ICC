package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "team_roles")
public class TeamRole extends EntityBase {

    private String name;

}
