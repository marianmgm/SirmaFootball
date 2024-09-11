package com.example.sirmafinalprojectfootball.repository;

import com.example.sirmafinalprojectfootball.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
