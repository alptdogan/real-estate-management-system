package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveRealEstateRequestDto;
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

    public RealEstate saveRealEstate(SaveRealEstateRequestDto saveRealEstateRequestDto){

        String realEstateNameRequest = saveRealEstateRequestDto.getRealEstateName();
        int squareMetersRequest = saveRealEstateRequestDto.getSquareMeters();
        int numberOfRoomsRequest = saveRealEstateRequestDto.getNumberOfRooms();
        int floorNoRequest = saveRealEstateRequestDto.getFloorNo();

        RealEstate realEstate = new RealEstate();

        realEstate.setRealEstateName(realEstateNameRequest);
        realEstate.setSquareMeters(squareMetersRequest);
        realEstate.setNumberOfRooms(numberOfRoomsRequest);
        realEstate.setFloorNo(floorNoRequest);

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
