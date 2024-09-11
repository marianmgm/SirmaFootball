package com.example.sirmafinalprojectfootball.service;

import com.example.sirmafinalprojectfootball.models.Team;
import com.example.sirmafinalprojectfootball.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void loadTeams(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                Team team = new Team();
                team.setId(Integer.parseInt(data[0]));
                team.setName(data[1]);
                team.setManagerFullName(data[2]);
                team.setGroupName(data[3]);
                teamRepository.save(team);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    }

