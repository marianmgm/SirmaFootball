package com.example.sirmafinalprojectfootball.repository;

import com.example.sirmafinalprojectfootball.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
}
