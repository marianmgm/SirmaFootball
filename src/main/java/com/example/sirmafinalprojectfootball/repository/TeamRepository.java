package com.example.sirmafinalprojectfootball.repository;

import com.example.sirmafinalprojectfootball.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

}
