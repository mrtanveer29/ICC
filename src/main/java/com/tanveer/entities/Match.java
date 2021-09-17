package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "matches")
public class Match extends EntityBase {
    private String name;
    @ManyToOne
    private GameType gameType; /// test . Odi
    @OneToMany(mappedBy = "match")
    private List<Participant> participants;
    private Enum status; // draw, completed , abandoned
    @Column(name = "total_overs")
    private float totalOvers;
    @Column(name = "total_days")
    private int totalDays;
    @ManyToOne
    private Event event;
    @OneToMany(mappedBy = "match")
    private List<Score> scores;

    @ManyToMany
    @JoinColumn(name = "umpire_id")
    private List<Member> umpires;
}
