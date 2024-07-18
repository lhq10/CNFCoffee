package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")

public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
