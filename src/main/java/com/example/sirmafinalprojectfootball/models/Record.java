package com.example.sirmafinalprojectfootball.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "records")
@Data
public class Record {
    @Id
    @Column(name = "record_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @Column (name="from_minutes")
    private int fromMinutes;

    @Column (name="to_minutes")
    private Integer toMinutes;
}
