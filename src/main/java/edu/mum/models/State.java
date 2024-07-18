package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "state")

public class State {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
