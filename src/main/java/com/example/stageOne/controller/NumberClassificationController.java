package com.example.stageOne.controller;

import com.example.stageOne.dto.NumberResponse;
import com.example.stageOne.service.NumberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class NumberClassificationController {
    private final NumberService numberService;

    @Autowired
    public NumberClassificationController(NumberService numberService){
        this.numberService = numberService;
    }

    @GetMapping("/classify-number")
    public NumberResponse classifyNumber(@RequestParam int number){
        return numberService.classifyNumber(number);
    }
}
