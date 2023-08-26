package com.alpdogan.realestatemanagementsystem.dto.response;

import lombok.Data;

@Data
public class ClientResponseDto {

    private int clientId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailAddress;

}
