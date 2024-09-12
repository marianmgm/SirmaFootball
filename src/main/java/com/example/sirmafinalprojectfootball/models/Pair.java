package com.example.sirmafinalprojectfootball.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Table(name = "pairs")
@Data
public class Pair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pair_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="playerA_id")
    private Player playerA;

    @ManyToOne
    @JoinColumn(name="playerB_id")
    private Player playerB;

    @ElementCollection
    @CollectionTable(name = "pair_integer_map", joinColumns = @JoinColumn(name = "pair_id"))
    @MapKeyColumn(name = "match_id")
    @Column(name = "time_played")
    private Map<Integer, Integer> matchIdMap;

    @Column(name = "total_time")
    private int totalTime;

    @Column(name = "matches_id")
    private int matchesId;




}
