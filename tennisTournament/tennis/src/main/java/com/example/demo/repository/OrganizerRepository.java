package com.example.demo.repository;

import com.example.demo.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer, String> {
    Optional<Organizer> findOrganizerByName(String name);
    void deleteOrganizerByName(String name);

}
