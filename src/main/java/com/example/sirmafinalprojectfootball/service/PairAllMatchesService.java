package com.example.sirmafinalprojectfootball.service;


import com.example.sirmafinalprojectfootball.models.Pair;
import com.example.sirmafinalprojectfootball.models.PairAllMatches;

public interface PairAllMatchesService {

    void generatePairsOfAllMatches();

    PairAllMatches getPairOfAllWithMaxTotalTime();
}
