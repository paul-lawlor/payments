package com.example.paymentsBackend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="payments")
public class Payment {
    @Column
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer OrderID;

    @Column
    private String PaymentType;
}
