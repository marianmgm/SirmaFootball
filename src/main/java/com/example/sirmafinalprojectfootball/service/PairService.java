package com.example.sirmafinalprojectfootball.service;

import com.example.sirmafinalprojectfootball.models.Pair;

public interface PairService {
    void generatePairs();

    Pair getPairWithMaxTotalTime();
}
