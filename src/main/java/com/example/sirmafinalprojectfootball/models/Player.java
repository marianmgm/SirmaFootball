package com.example.sirmafinalprojectfootball.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "players")
@Data
public class Player {
    @Id
    @Column(name = "player_id")
    private int id;

    @Column(name="team_number")
    private int teamNumber;

    @Column(name="position")
    private String position;

    @Column(name="full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

}
