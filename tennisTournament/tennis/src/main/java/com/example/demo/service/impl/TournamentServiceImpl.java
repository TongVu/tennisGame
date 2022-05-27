package com.example.demo.service.impl;

import com.example.demo.entity.Tournament;
import com.example.demo.repository.TournamentRepository;
import com.example.demo.service.TournamentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TournamentServiceImpl implements TournamentService {
    TournamentRepository tournamentRepository;


    @Override
    public List<Tournament> getAllTournament() {
        return tournamentRepository.findAll();
    }

    @Override
    public void saveTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    @Override
    public Optional<Tournament> findTournamentByName(String name) {
        return tournamentRepository.findTournamentByName(name);
    }

    @Override
    public void deleteTournamentByName(String name) {
        tournamentRepository.deleteTournamentByName(name);
    }
}
