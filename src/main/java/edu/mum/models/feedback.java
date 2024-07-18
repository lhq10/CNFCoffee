package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback")

public class feedback {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
