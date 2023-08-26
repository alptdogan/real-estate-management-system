package com.alpdogan.realestatemanagementsystem.dto.request;

import lombok.Data;

@Data
public class SaveRealEstateRequestDto {

    private String realEstateName;
    private int squareMeters;
    private int numberOfRooms;
    private int floorNo;

    private int clientId;
    private String realEstateType;

}
