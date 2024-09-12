package com.example.sirmafinalprojectfootball.service;

import com.example.sirmafinalprojectfootball.models.Pair;
import com.example.sirmafinalprojectfootball.models.PairAllMatches;
import com.example.sirmafinalprojectfootball.repository.PairAllMatchesRepository;
import com.example.sirmafinalprojectfootball.repository.PairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PairAllMatchesServiceImp implements PairAllMatchesService {
    private final PairAllMatchesRepository pairAllMatchesRepository;
    private final PairRepository pairRepository;

    @Autowired
    public PairAllMatchesServiceImp(PairAllMatchesRepository pairAllMatchesRepository, PairRepository pairRepository) {
        this.pairAllMatchesRepository = pairAllMatchesRepository;
        this.pairRepository = pairRepository;
    }

    @Override
    public void generatePairsOfAllMatches() {
        List<Pair> pairs = pairRepository.findAll();
        PairAllMatches pairAllMatches = new PairAllMatches();
        for (int i = 0; i < pairs.size(); i++) {
            int timeTotal = 0;
            for (int j = i + 1; j < pairs.size(); j++) {
                Pair pair1 = pairs.get(i);
                Pair pair2 = pairs.get(j);
                Map<Integer, Integer> matchIdMap1 = new HashMap<>();
                if (pair1.getPlayerA().getId() == pair2.getPlayerA().getId() && pair1.getPlayerB().getId() == pair2.getPlayerB().getId()) {
                    matchIdMap1.put(pair1.getMatchesId(), pair1.getTotalTime());
                    matchIdMap1.put(pair1.getMatchesId(), pair1.getTotalTime());

                    if (timeTotal == 0) {
                        timeTotal += pair1.getTotalTime();
                    }
                    timeTotal += pair2.getTotalTime();
                }
                if (timeTotal > 0) {
                    pairAllMatches.setPair(pair1);
                    pairAllMatches.setTotalTime(timeTotal);
                    pairAllMatches.setMatchIdMap(matchIdMap1);
                    pairAllMatchesRepository.save(pairAllMatches);
                }

            }
        }
    }
    @Override
    public PairAllMatches getPairOfAllWithMaxTotalTime() {
        return pairAllMatchesRepository.findPairWithMaxTotalTime();
    }
}
