package com.example.sirmafinalprojectfootball.repository;

import com.example.sirmafinalprojectfootball.models.PairAllMatches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PairAllMatchesRepository extends JpaRepository<PairAllMatches, Integer> {
    @Query("SELECT p FROM Pair p ORDER BY p.totalTime DESC LIMIT 1")
    PairAllMatches findPairWithMaxTotalTime();
}
