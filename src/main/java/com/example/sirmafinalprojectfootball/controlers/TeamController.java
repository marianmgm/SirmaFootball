package com.example.sirmafinalprojectfootball.controlers;

import com.example.sirmafinalprojectfootball.service.TeamService;
import com.example.sirmafinalprojectfootball.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamServiceImpl teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/loadTeams")

    public String loadTeams(@RequestParam String filePath) {
        teamService.loadTeams(filePath);
        return "Teams loaded successfully!" + filePath;
    }



}
