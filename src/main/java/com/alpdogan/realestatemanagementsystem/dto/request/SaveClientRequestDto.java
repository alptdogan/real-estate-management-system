package com.alpdogan.realestatemanagementsystem.dto.request;

import lombok.Data;

@Data
public class SaveClientRequestDto {

    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailAddress;

//    private int realEstateId;

}
