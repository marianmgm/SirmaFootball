package com.example.sirmafinalprojectfootball.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "matches")
@Data
public class Match {
    @Id
    @Column(name = "matches_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="aTeam_id")
    private Team aTeamId;

    @ManyToOne
    @JoinColumn(name="bTeam_id")
    private Team bTeamId;

    @Column(name="date")
    private LocalDate date;

    @Column(name="score")
    private String score;


}
