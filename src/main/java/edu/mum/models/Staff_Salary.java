package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "staff_salary")
public class Staff_Salary {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
