package com.example.demo.service.impl;

import com.example.demo.entity.Organizer;
import com.example.demo.repository.OrganizerRepository;
import com.example.demo.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class OrganizerServiceImpl implements OrganizerService {
    OrganizerRepository organizerRepository;

    @Override
    public List<Organizer> getAllOrganizer() {
        return organizerRepository.findAll();
    }

    @Override
    public void saveOrganizer(Organizer organizer) {
        organizerRepository.save(organizer);
    }

    @Override
    public Optional<Organizer> findOrganizerByName(String name) {
        return organizerRepository.findOrganizerByName(name);
    }

    @Override
    public void deleteOrganizerByName(String name) {
        organizerRepository.deleteOrganizerByName(name);
    }
}
