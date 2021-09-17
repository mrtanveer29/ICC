package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score extends EntityBase {
    @ManyToOne
    private Match match;
    @ManyToOne
    private Player player;
    private int score;
    private int fours;
    private int sixes;
    @Column(name = "bowl_played")
    private int bowlPlayed;
    @Column(name = "wiket_taken")
    private int wiketTaken;
    @Column(name = "total_bowled")
    private int totalBowled;
    private int maiden;
    @Column(name = "no_ball")
    private int noBall;
    @Column(name = "wide_ball")
    private int wideBall;
    @Column(name = "dead_ball")
    private int deadBall;

}
