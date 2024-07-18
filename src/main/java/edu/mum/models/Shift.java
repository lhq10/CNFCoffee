package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "shift")

public class Shift {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
