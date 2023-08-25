package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import com.alpdogan.realestatemanagementsystem.repository.RealEstateRepository;
import org.springframework.stereotype.Service;

@Service
public class RealEstateService {

    private RealEstateRepository realEstateRepository;

    public RealEstateService(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    public RealEstate saveRealEstate(RealEstate realEstate){
        return realEstateRepository.save(realEstate);
    }

}
