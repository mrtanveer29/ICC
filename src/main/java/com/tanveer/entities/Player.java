package com.tanveer.entities;

import com.tanveer.entities.Common.EntityBase;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="players")
public class Player extends EntityBase {
    @OneToOne
    private Member teamMember;
    @ManyToOne
    private  Team team;
    @Column(name = "is_bowler")
    private boolean isBowler;
    @Column(name = "is_batsman")
    private boolean isBatsman;
    @Column(name = "is_captain")
    private boolean isCaptain;
    @Column(name = "is_wiket_keeper")
    private boolean isWiketKeeper;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_confirmed")
    private boolean isConfirmed;
    private String status;
    @Column(name = "join_date")
    private Date joinDate;

    @OneToMany(mappedBy = "player")
    private List<Score> scores;
}
