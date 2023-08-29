package com.alpdogan.realestatemanagementsystem.controller;

import com.alpdogan.realestatemanagementsystem.dto.response.ClientResponseDto;
import com.alpdogan.realestatemanagementsystem.dto.response.RealEstateResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.*;
import com.alpdogan.realestatemanagementsystem.service.ClientService;
import com.alpdogan.realestatemanagementsystem.service.RealEstateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/realEstates")
public class RealEstateController {

    private RealEstateService realEstateService;
    private ClientService clientService;

    public RealEstateController(RealEstateService realEstateService, ClientService clientService) {
        this.realEstateService = realEstateService;
        this.clientService = clientService;
    }

    // thymeleaf'te saverequestdto ile işlem yaptıramadaım maalesef. direkt entity kullanmak üzere burayı ver servisi güncelledim.
    @PostMapping("/addRealEstate")
    public String addRealEstate(@ModelAttribute("realEstate") RealEstate realEstate) {
        realEstateService.saveRealEstate(realEstate);
        return "redirect:/realEstates";
    }

    @GetMapping("/new")
    public String displayRealEstateForm (Model model) {

        RealEstate realEstate = new RealEstate();
        List<ClientResponseDto> clientResponseDtos = clientService.getAllClients();

        model.addAttribute("realEstate", realEstate);
        model.addAttribute("allClients", clientResponseDtos);

        return "real-estate-new";

    }

    @GetMapping("{realEstateId}")
    public Optional<RealEstate> getRealEstateById(@PathVariable int realEstateId) {
        return realEstateService.getRealEstateById(realEstateId);
    }

    @GetMapping
    public String getAllRealEstates(Model model) {

        List<RealEstateResponseDto> realEstateResponseDtos = realEstateService.getAllRealEstates();
        model.addAttribute("realEstate", realEstateResponseDtos);

        return "real-estate-list";
    }

    @GetMapping("/updateRealEstateForm")
    public String updateRealEstateForm(Model model) {

        RealEstate realEstate = new RealEstate();
        List<ClientResponseDto> clientResponseDtos = clientService.getAllClients();

        model.addAttribute("realEstate", realEstate);
        model.addAttribute("allClients", clientResponseDtos);

        return "real-estate-new";

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

    @GetMapping("/getRealEstatesByItsEnumeratedProperties")
    public List<RealEstateResponseDto> getRealEstatesByItsEnumeratedProperties(@RequestParam ERealEstateType eRealEstateType,
                                                                     @RequestParam ESaleOrRent eSaleOrRent,
                                                                     @RequestParam ETown eTown) {
        return realEstateService.getRealEstatesByItsEnumeratedProperties(eRealEstateType, eSaleOrRent, eTown);
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

















