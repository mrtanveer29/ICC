package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country extends EntityBase {
    private String name;
    @OneToMany(mappedBy = "country")
    private List<Member> members;

    @OneToOne(mappedBy = "country")
    private Team team;

}
