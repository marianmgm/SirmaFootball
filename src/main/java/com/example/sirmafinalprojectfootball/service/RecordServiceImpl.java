package com.example.sirmafinalprojectfootball.service;

import com.example.sirmafinalprojectfootball.models.Match;
import com.example.sirmafinalprojectfootball.models.Player;
import com.example.sirmafinalprojectfootball.models.Record;
import com.example.sirmafinalprojectfootball.repository.MatchRepository;
import com.example.sirmafinalprojectfootball.repository.PlayerRepository;
import com.example.sirmafinalprojectfootball.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final PlayerRepository playerRepository;

    private final MatchRepository matchRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository, PlayerRepository playerRepository, MatchRepository matchRepository) {
        this.recordRepository = recordRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public void loadRecords(String filePath) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Record record = new Record();
                record.setId(Integer.parseInt(data[0]));
                Player player = playerRepository.findById(Integer.parseInt(data[1])).orElseThrow(() -> new RuntimeException("Player not found"));
                record.setPlayer(player);
                Match match = matchRepository.findById(Integer.parseInt(data[2])).orElseThrow(() -> new RuntimeException("Match not found"));
                record.setMatch(match);
                record.setFromMinutes(Integer.parseInt(data[3]));
                int toMinutes=0;
                if(data[4].equals("NULL")){
                toMinutes=90;}
                else{
                    toMinutes=Integer.parseInt(data[4]);
                }
                record.setToMinutes(toMinutes);
                recordRepository.save(record);

            }
            br.close();

        }   catch (Exception e) {
            e.printStackTrace();
        }

    }
}
