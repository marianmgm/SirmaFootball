package com.example.sirmafinalprojectfootball.controlers;

import com.example.sirmafinalprojectfootball.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }
    @GetMapping("/loadRecords")
    public String loadRecords(@RequestParam String filePath){
        recordService.loadRecords(filePath);
        return "Records loaded successfully!"+ filePath;
    }
}
