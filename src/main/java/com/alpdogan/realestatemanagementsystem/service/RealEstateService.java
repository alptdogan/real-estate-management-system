package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import com.alpdogan.realestatemanagementsystem.repository.RealEstateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealEstateService {

    private RealEstateRepository realEstateRepository;

    public RealEstateService(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    public RealEstate saveRealEstate(RealEstate realEstate){
        return realEstateRepository.save(realEstate);
    }

    public Optional<RealEstate> getRealEstateById(int realEstateId) {
        return realEstateRepository.findById(realEstateId);
    }

    public List<RealEstate> getAllRealEstates() {
        return realEstateRepository.findAll();
    }

    public void deleteRealEstateById(int realEstateId) {
        realEstateRepository.deleteById(realEstateId);
    }

}
