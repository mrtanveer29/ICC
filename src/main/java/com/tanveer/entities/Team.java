package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team extends EntityBase {
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Player> players;
    @OneToOne
    @JoinColumn(name="couch_id")
    private Member couch;
    @OneToOne
    @JoinColumn(name="manager_id")
    private Member manager;
    @OneToOne
    private Country country;











}
