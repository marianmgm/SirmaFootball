package com.example.sirmafinalprojectfootball.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Table(name = "pair_all_matches")
@Data
public class PairAllMatches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="pair_id")
    private Pair pair;

    @Column(name = "total_time")
    private int totalTime;

    @ElementCollection
    @CollectionTable(name = "pair_all_matches_map", joinColumns = @JoinColumn(name = "pair_all_matches_id"))
    @MapKeyColumn(name = "map_key")
    @Column(name = "value")
    private Map<Integer, Integer> matchIdMap;

}
