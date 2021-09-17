package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "events")
public class Event extends EntityBase {
    private String name;
    @ManyToOne
    private EventType type; // World cup . Friendly
    @OneToMany(mappedBy = "event")
    private List<Match> matches;
}
