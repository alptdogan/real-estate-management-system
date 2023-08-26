package com.alpdogan.realestatemanagementsystem.dto.response;

import lombok.Data;

@Data
public class RealEstateResponseDto {

    private int realEstateId;
    private String realEstateName;
    private int squareMeters;
    private int numberOfRooms;
    private int floorNo;

    private int clientId;
    private String realEstateType;

}
