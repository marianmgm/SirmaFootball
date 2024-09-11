package com.example.sirmafinalprojectfootball.service;

import com.example.sirmafinalprojectfootball.models.Match;
import com.example.sirmafinalprojectfootball.models.Team;
import com.example.sirmafinalprojectfootball.repository.MatchRepository;
import com.example.sirmafinalprojectfootball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

    public MatchServiceImpl(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }


    @Override
    public void loadMatches(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Match match = new Match();
                int teamIdA = Integer.parseInt(data[1]);
                Team teamA = teamRepository.findById(teamIdA).orElseThrow(() -> new RuntimeException("Team not found"));
                int teamIdB = Integer.parseInt(data[2]);
                Team teamB = teamRepository.findById(teamIdB).orElseThrow(() -> new RuntimeException("Team not found"));
                match.setId(Integer.parseInt(data[0]));
                match.setATeamId(teamA);
                match.setBTeamId(teamB);
                try {
                    LocalDate date = LocalDate.parse(data[3], dateFormat);
                    match.setDate(date);
                } catch (DateTimeParseException e) {
                    throw new RuntimeException("Invalid date format: " + data[3], e);
                }
                match.setScore(data[4]);
                matchRepository.save(match);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
