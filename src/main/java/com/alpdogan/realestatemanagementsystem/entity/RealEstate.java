package com.alpdogan.realestatemanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "real_estate")
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column(name = "real_estate_name")
    private String realEstateName;

    @Column(name = "square_meters")
    private int squareMeters;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @Column(name = "floor_no")
    private int floorNo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "real_estate_type")
    private ERealEstateType eRealEstateType;


}
