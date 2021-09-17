package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class Participant extends EntityBase {
    @OneToOne
    private Team team;
    private boolean won;
    private boolean loose;
    @ManyToOne
    private Match match;

}
