package com.alpdogan.realestatemanagementsystem.controller;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveRealEstateRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.response.RealEstateResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import com.alpdogan.realestatemanagementsystem.service.RealEstateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/real_estates")
public class RealEstateController {

    private RealEstateService realEstateService;

    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @PostMapping("/addRealEstate")
    public RealEstate addRealEstate(@RequestBody SaveRealEstateRequestDto saveRealEstateRequestDto) {
        return realEstateService.saveRealEstate(saveRealEstateRequestDto);
    }

    @GetMapping("{realEstateId}")
    public Optional<RealEstate> getRealEstateById(@PathVariable int realEstateId) {
        return realEstateService.getRealEstateById(realEstateId);
    }

    @GetMapping
    public List<RealEstateResponseDto> getAllRealEstates() {
        return realEstateService.getAllRealEstates();
    }

    @DeleteMapping("/{realEstateId}")
    public void deleteRealEstateById(@PathVariable int realEstateId) {
        realEstateService.deleteRealEstateById(realEstateId);
    }

}
