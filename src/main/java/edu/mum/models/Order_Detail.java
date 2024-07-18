package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")

public class Order_Detail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
