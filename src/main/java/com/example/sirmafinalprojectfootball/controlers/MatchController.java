package com.example.sirmafinalprojectfootball.controlers;

import com.example.sirmafinalprojectfootball.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;
    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    @GetMapping("/loadMatches")
    public String loadMatches(String filePath) {
        matchService.loadMatches(filePath);
        return "Matches loaded successfully!" + filePath;
    }
}
