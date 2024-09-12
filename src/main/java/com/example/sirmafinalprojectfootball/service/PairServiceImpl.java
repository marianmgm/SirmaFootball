package com.example.sirmafinalprojectfootball.service;

import com.example.sirmafinalprojectfootball.models.Pair;
import com.example.sirmafinalprojectfootball.models.Player;
import com.example.sirmafinalprojectfootball.models.Record;
import com.example.sirmafinalprojectfootball.repository.PairRepository;
import com.example.sirmafinalprojectfootball.repository.PlayerRepository;
import com.example.sirmafinalprojectfootball.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        for (int i = 0; i < records.size(); i++) {
            for (int j = i + 1; j < records.size(); j++) {
                Record record1 = records.get(i);
                Record record2 = records.get(j);
                if (record1.getPlayer().getId() == record2.getPlayer().getId()) {
                    continue;
                }
                if (record1.getMatch().equals(record2.getMatch())) {
                    Pair pair = getPair(record1, record2);
                    pairRepository.save(pair);
                }
            }
        }
//        List<Pair> pairs = pairRepository.findAll();
//        for(int i = 0; i < pairs.size(); i++) {
//            int timeTotal = 0;
//            for(int j = i + 1; j < pairs.size(); j++) {
//                Pair pair1 = pairs.get(i);
//                Pair pair2 = pairs.get(j);
//                if(pair1.getPlayerA().getId() == pair2.getPlayerA().getId() && pair1.getPlayerB().getId() == pair2.getPlayerB().getId()) {
//                    Map<Integer, Integer> matchIdMap1 = new HashMap<>();
//                    matchIdMap1.putAll(pair1.getMatchIdMap());
//                    matchIdMap1.putAll(pair2.getMatchIdMap());
//                    if(timeTotal==0) {
//                        timeTotal += pair1.getTotalTime();
//                    }
//                    timeTotal += pair2.getTotalTime();
//                }
//
//            }
      //  }
    }

    private static Pair getPair(Record record1, Record record2) {
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
        }
        pair.setMatchIdMap(timePlayedTogetherMap);
        pair.setTotalTime(overlapEnd-overlapStart);
        pair.setMatchesId(record1.getMatch().getId());
        return pair;
    }

    @Override
    public Pair getPairWithMaxTotalTime() {
        return pairRepository.findPairWithMaxTotalTime();
    }
}
