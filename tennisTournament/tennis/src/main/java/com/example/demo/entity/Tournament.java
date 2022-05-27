package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Builder

public class Tournament {
    @Column(unique = true)
    private String name;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private String sponsors;

    @ManyToOne
    @JoinColumn
    private Organizer organizer;

}
