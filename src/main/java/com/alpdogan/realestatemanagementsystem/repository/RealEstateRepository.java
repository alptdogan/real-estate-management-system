package com.alpdogan.realestatemanagementsystem.repository;

import com.alpdogan.realestatemanagementsystem.dto.response.TypeRealEstateResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.ERealEstateType;
import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {

    @Query("SELECT re FROM RealEstate re WHERE re.numberOfRooms = :numberOfRooms")
    List<RealEstate> searchByNumberOfRooms(@Param("numberOfRooms") int numberOfRooms);

    @Query("SELECT re FROM RealEstate re WHERE re.squareMeters = :squareMeters")
    List<RealEstate> searchBySquareMeters(@Param("squareMeters") int squareMeters);

    @Query("SELECT re FROM RealEstate re WHERE re.floorNo = :floorNo")
    List<RealEstate> searchByFloorNo(@Param("floorNo") int floorNo);

//    @Query("SELECT re FROM RealEstate re WHERE re.eRealEstateType = :eRealEstateType")
//    List<RealEstate> searchByRealEstateType();

    @Query("SELECT re FROM RealEstate re WHERE re.eRealEstateType = :eRealEstateType")
    List<RealEstate> searchByRealEstateType(@Param("eRealEstateType") ERealEstateType eRealEstateType);

}
