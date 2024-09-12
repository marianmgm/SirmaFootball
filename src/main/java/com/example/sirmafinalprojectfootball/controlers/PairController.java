package com.example.sirmafinalprojectfootball.controlers;

import com.example.sirmafinalprojectfootball.models.Pair;
import com.example.sirmafinalprojectfootball.models.PairAllMatches;
import com.example.sirmafinalprojectfootball.service.PairAllMatchesService;
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
    private final PairAllMatchesService pairAllMatchesService;

    @Autowired
    public PairController(PairService pairService, PairAllMatchesService pairAllMatchesService) {
        this.pairService = pairService;
        this.pairAllMatchesService = pairAllMatchesService;
    }

    @PostMapping("/generate")
    public void generatePairs() {
        pairService.generatePairs();
    }

//    @GetMapping("/maxTotalTime")
//    public Pair getPairWithMaxTotalTime() {
//        return pairService.getPairWithMaxTotalTime();
//    }

    @PostMapping("/generateAllMatches")
    public void generatePairsOfAllMatches(){
        pairAllMatchesService.generatePairsOfAllMatches();
    }
    @GetMapping("/maxTotalTime")
    public PairAllMatches getPairOfAllWithMaxTotalTime() {
        return pairAllMatchesService.getPairOfAllWithMaxTotalTime();
    }

}
