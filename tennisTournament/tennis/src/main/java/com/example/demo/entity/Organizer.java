package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@Builder

public class Organizer {
    @Column(unique = true)
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;
}
