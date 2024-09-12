package com.example.sirmafinalprojectfootball.service;

import com.example.sirmafinalprojectfootball.models.Pair;
import com.example.sirmafinalprojectfootball.models.Player;
import com.example.sirmafinalprojectfootball.models.Record;
import com.example.sirmafinalprojectfootball.models.Team;
import com.example.sirmafinalprojectfootball.repository.PlayerRepository;
import com.example.sirmafinalprojectfootball.repository.RecordRepository;
import com.example.sirmafinalprojectfootball.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final TeamRepository teamRepository;

    private final RecordRepository recordRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository, RecordRepository recordRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.recordRepository = recordRepository;
    }

    @Override
    public void loadPlayers(String filePath) {
        try {
             BufferedReader br = new BufferedReader(new FileReader(filePath));
             String line;
             br.readLine();
             while ((line = br.readLine()) != null) {
                 String[] data = line.split(",");
                 Player player = new Player();
                 player.setId(Integer.parseInt(data[0]));
                 player.setTeamNumber(Integer.parseInt(data[1]));
                 player.setPosition(data[2]);
                 player.setFullName(data[3]);
                 int teamId = Integer.parseInt(data[4]);
                 Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
                 player.setTeam(team);
                 playerRepository.save(player);
             }
             br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
