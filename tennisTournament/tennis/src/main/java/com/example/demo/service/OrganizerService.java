package com.example.demo.service;

import com.example.demo.entity.Organizer;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface OrganizerService {
    List<Organizer> getAllOrganizer();

    void saveOrganizer(Organizer organizer);

    Optional<Organizer> findOrganizerByName(String name);

    void deleteOrganizerByName(String name);

}
