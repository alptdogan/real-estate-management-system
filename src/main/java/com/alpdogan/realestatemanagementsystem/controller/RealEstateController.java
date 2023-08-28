package com.alpdogan.realestatemanagementsystem.controller;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveRealEstateRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.request.UpdateRealEstateRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.response.RealEstateResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.ERealEstateType;
import com.alpdogan.realestatemanagementsystem.entity.ESaleOrRent;
import com.alpdogan.realestatemanagementsystem.entity.ETown;
import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import com.alpdogan.realestatemanagementsystem.service.RealEstateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/realEstates")
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

    @PutMapping("/updateRealEstateById")
    public RealEstate updateRealEstateById(@RequestBody UpdateRealEstateRequestDto updateRealEstateRequestDto) {
        return realEstateService.updateRealEstateById(updateRealEstateRequestDto);
    }

    @DeleteMapping("/{realEstateId}")
    public void deleteRealEstateById(@PathVariable int realEstateId) {
        realEstateService.deleteRealEstateById(realEstateId);
    }

    @GetMapping("/numberOfRooms/{numberOfRooms}")
    public List<RealEstate> getRealEstateByNumberOfRooms(@PathVariable int numberOfRooms) {
        return realEstateService.getRealEstateByNumberOfRooms(numberOfRooms);
    }

    @GetMapping("/squareMeters/{squareMeters}")
    public List<RealEstate> getRealEstateBySquareMeters(@PathVariable int squareMeters) {
        return realEstateService.getRealEstateBySquareMeters(squareMeters);
    }

    @GetMapping("/floorNo/{floorNo}")
    public List<RealEstate> getRealEstateByFloorNo(@PathVariable int floorNo) {
        return realEstateService.getRealEstateByFloorNo(floorNo);
    }

    @GetMapping("/price/{price}")
    public List<RealEstate> getRealEstateByPrice(@PathVariable int price) {
        return realEstateService.getRealEstateByPrice(price);
    }

    @GetMapping("/realEstateType/{realEstateType}")
    public List<RealEstateResponseDto> getRealEstateByRealEstateType(@PathVariable ERealEstateType realEstateType) {
        return realEstateService.getRealEstateByRealEstateType(realEstateType);
    }

    @GetMapping("/saleOrRent/{saleOrRent}")
    public List<RealEstateResponseDto> getRealEstateBySaleOrRent (@PathVariable ESaleOrRent saleOrRent) {
        return realEstateService.getRealEstateBySaleOrRent(saleOrRent);
    }

    @GetMapping("/town/{town}")
    public List<RealEstateResponseDto> getRealEstateByTown(@PathVariable ETown town) {
        return realEstateService.getRealEstateByTown(town);
    }

    @GetMapping("/getRealEstatesByItsProperties")
    public List<RealEstateResponseDto> getRealEstatesByItsProperties(@RequestParam int numberOfRooms,
                                                                     @RequestParam int floorNo,
                                                                     @RequestParam int squareMeters,
                                                                     @RequestParam ERealEstateType eRealEstateType,
                                                                     @RequestParam ESaleOrRent eSaleOrRent,
                                                                     @RequestParam ETown eTown) {
        return realEstateService.getRealEstatesByItsProperties(numberOfRooms, floorNo, squareMeters, eRealEstateType, eSaleOrRent, eTown);
    }

}

















