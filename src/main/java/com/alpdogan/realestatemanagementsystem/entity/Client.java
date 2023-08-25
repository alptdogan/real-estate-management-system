package com.alpdogan.realestatemanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "client_id")
    private int clientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column (name = "phone_number")
    private long phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

}
