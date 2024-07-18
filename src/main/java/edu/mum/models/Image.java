package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "image")

public class Image {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
