package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "game_types")
public class GameType extends EntityBase {
    private String name;
    @OneToMany(mappedBy = "gameType")
    private List<Match> matches;
}
