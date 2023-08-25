package com.alpdogan.realestatemanagementsystem.dto.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RealEstateResponseDto {

    private int realEstateId;
    private String realEstateName;
    private int squareMeters;
    private int numberOfRooms;
    private int floorNo;

}
