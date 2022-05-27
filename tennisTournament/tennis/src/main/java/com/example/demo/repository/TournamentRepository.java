package com.example.demo.repository;

import com.example.demo.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, String> {
    Optional<Tournament> findTournamentByName(String name);
    void deleteTournamentByName(String name);
}
