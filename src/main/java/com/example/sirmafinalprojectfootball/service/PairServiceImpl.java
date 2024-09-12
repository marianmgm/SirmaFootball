package com.example.sirmafinalprojectfootball.service;

import com.example.sirmafinalprojectfootball.models.Pair;
import com.example.sirmafinalprojectfootball.models.Player;
import com.example.sirmafinalprojectfootball.models.Record;
import com.example.sirmafinalprojectfootball.repository.PairRepository;
import com.example.sirmafinalprojectfootball.repository.PlayerRepository;
import com.example.sirmafinalprojectfootball.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PairServiceImpl implements PairService {
    private final PairRepository pairRepository;

    private final RecordRepository recordRepository;

    @Autowired
    public PairServiceImpl(PairRepository pairRepository,  RecordRepository recordRepository) {
        this.pairRepository = pairRepository;
        this.recordRepository = recordRepository;
    }
    @Override
    public void generatePairs() {
        List<Record> records = recordRepository.findAll();
        int timeTotal=0;
        for (int i = 0; i < records.size(); i++) {
            for (int j = i+1; j < records.size(); j++) {
                Record record1 = records.get(i);
                Record record2 = records.get(j);
                if (record1.getMatch().equals(record2.getMatch())) {
                    Pair pair = new Pair();
                    Player player1 = record1.getPlayer();
                    Player player2 = record2.getPlayer();
                    pair.setPlayerA(player1);
                    pair.setPlayerB(player2);
                    Map<Integer, Integer> timePlayedTogetherMap = new HashMap<>();
                    int overlapStart = Math.max(record1.getFromMinutes(), record2.getFromMinutes());
                    int overlapEnd = Math.min(record1.getToMinutes(), record2.getToMinutes());
                    if (overlapStart < overlapEnd) {
                        int overlapTime = overlapEnd - overlapStart;
                        timePlayedTogetherMap.put(record1.getMatch().getId(), overlapTime);
                        timeTotal+=overlapTime;
                    }
                    pair.setMatchIdMap(timePlayedTogetherMap);
                    pair.setTotalTime(timeTotal);
                    pairRepository.save(pair);
                }

            }
        }
    }
    @Override
    public Pair getPairWithMaxTotalTime() {
        return pairRepository.findPairWithMaxTotalTime();
    }
}
