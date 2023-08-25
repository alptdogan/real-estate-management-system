package com.alpdogan.realestatemanagementsystem.dto.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SaveClientRequestDto {

    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailAddress;

}
