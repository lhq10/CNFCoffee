package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_state")

public class Order_State {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
