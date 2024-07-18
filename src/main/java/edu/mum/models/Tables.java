package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "table")

public class Tables {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
