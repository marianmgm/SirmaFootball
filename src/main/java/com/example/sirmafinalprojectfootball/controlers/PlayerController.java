package com.example.sirmafinalprojectfootball.controlers;

import com.example.sirmafinalprojectfootball.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping("/loadPlayers")
    public String loadPlayers(@RequestParam String filePath) {
        playerService.loadPlayers(filePath);
        return "Players loaded successfully!" + filePath;
    }
}
