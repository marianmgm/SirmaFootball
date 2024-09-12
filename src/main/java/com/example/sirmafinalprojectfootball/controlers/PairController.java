package com.example.sirmafinalprojectfootball.controlers;

import com.example.sirmafinalprojectfootball.models.Pair;
import com.example.sirmafinalprojectfootball.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pair")
public class PairController {
    private final PairService pairService;
    @Autowired
    public PairController(PairService pairService) {
        this.pairService = pairService;
    }
    @PostMapping("/generate")
    public void generatePairs() {
        pairService.generatePairs();
    }
    @GetMapping("/maxTotalTime")
    public Pair getPairWithMaxTotalTime() {
        return pairService.getPairWithMaxTotalTime();
    }

}
