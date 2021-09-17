package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "event_types")
public class EventType extends EntityBase {
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Event> events;
}
