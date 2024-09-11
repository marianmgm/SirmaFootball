package com.example.sirmafinalprojectfootball.repository;

import com.example.sirmafinalprojectfootball.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
}
