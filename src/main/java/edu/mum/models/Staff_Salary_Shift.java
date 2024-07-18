package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "staff_salary_shift")
public class Staff_Salary_Shift {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
