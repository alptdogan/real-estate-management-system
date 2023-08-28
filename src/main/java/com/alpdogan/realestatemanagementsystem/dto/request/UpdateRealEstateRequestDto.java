package com.alpdogan.realestatemanagementsystem.dto.request;

import lombok.Data;

@Data
public class UpdateRealEstateRequestDto {

    private int realEstateId;
    private String advertTitle;
    private String realEstateAddress;
    private int squareMeters;
    private int numberOfRooms;
    private int floorNo;
    private int price;

    private int clientId;
    private String realEstateType;
    private String saleOrRent;
    private String town;

}
