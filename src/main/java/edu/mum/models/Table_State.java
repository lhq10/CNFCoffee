package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_permission")

public class Table_State {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
