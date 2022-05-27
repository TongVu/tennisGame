package com.example.demo.service;

import com.example.demo.entity.Tournament;

import java.util.List;
import java.util.Optional;

public interface TournamentService {
    List<Tournament> getAllTournament();

    void saveTournament(Tournament tournament);

    Optional<Tournament> findTournamentByName(String name);

    void deleteTournamentByName(String name);

}
