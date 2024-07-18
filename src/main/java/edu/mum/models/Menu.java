package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")

public class Menu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
