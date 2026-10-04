package com.betIA.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betIA.backend.service.FootballService;
import com.betIA.backend.service.GeminiService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AppController {

    @Autowired
    private FootballService footballService;

    @Autowired
    private GeminiService geminiService;

    // Endpoint alterado para receber a data via parâmetro (ex: /api/jogos?data=2026-10-04)
    @GetMapping("/jogos")
    public String getJogosPorData(@RequestParam String data) {
        return footballService.buscarJogosPorData(data);
    }

    @GetMapping("/analise")
    public String getAnaliseIa(
            @RequestParam String timeCasa,
            @RequestParam String timeFora,
            @RequestParam int palpiteCasa,
            @RequestParam int palpiteFora) {
        
        return geminiService.analisarPalpite(timeCasa, timeFora, palpiteCasa, palpiteFora);
    }
}