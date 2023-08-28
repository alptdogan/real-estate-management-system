package com.alpdogan.realestatemanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "real_estates")
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "real_estate_id")
    private int realEstateId;

    @Column(name = "advert_title")
    private String advertTitle;

    @Column(name = "real_estate_address")
    private String realEstateAddress;

    @Column(name = "square_meters")
    private int squareMeters;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @Column(name = "floor_no")
    private int floorNo;

    @Column(name = "price")
    private int price;

    @ManyToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "real_estate_type")
    private ERealEstateType eRealEstateType;

    @Enumerated(EnumType.STRING)
    @Column(name = "sale_or_rent")
    private ESaleOrRent eSaleOrRent;

    @Enumerated(EnumType.STRING)
    @Column(name = "town")
    private ETown eTown;

}
