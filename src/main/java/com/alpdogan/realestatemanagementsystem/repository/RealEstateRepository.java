package com.alpdogan.realestatemanagementsystem.repository;

import com.alpdogan.realestatemanagementsystem.dto.response.RealEstateResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.ERealEstateType;
import com.alpdogan.realestatemanagementsystem.entity.ESaleOrRent;
import com.alpdogan.realestatemanagementsystem.entity.ETown;
import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {

    @Query("SELECT re FROM RealEstate re WHERE re.numberOfRooms = :numberOfRooms")
    List<RealEstate> searchByNumberOfRooms(@Param("numberOfRooms") int numberOfRooms);

//    @Query("SELECT re FROM RealEstate re WHERE re.squareMeters = :squareMeters")
//    List<RealEstateResponseDto> searchBySquareMeters(@Param("squareMeters") int squareMeters);

    @Query("SELECT re FROM RealEstate re WHERE re.floorNo = :floorNo")
    List<RealEstate> searchByFloorNo(@Param("floorNo") int floorNo);

    @Query("SELECT re FROM RealEstate re WHERE re.price = :price")
    List<RealEstate> searchByPrice(@Param("price") int price);

    @Query("SELECT re FROM RealEstate re WHERE re.eRealEstateType = :eRealEstateType")
    List<RealEstate> searchByRealEstateType(@Param("eRealEstateType") ERealEstateType eRealEstateType);

    @Query("SELECT re FROM RealEstate re WHERE re.eSaleOrRent = :eSaleOrRent")
    List<RealEstate> searchBySaleOrRent(@Param("eSaleOrRent") ESaleOrRent eSaleOrRent);

//    @Query("SELECT re FROM RealEstate re WHERE re.eTown = :eTown")
//    List<RealEstate> searchByTown(@Param("eTown") ETown eTown);

    @Query("SELECT re FROM RealEstate re " +
            "WHERE re.eRealEstateType = :eRealEstateType " +
            "AND re.eSaleOrRent = :eSaleOrRent " +
            "AND re.eTown = :eTown")
    List<RealEstate> findRealEstatesByItsEnumeratedProperties(@Param("eRealEstateType") ERealEstateType realEstateType,
                                                    @Param("eSaleOrRent") ESaleOrRent saleOrRent,
                                                    @Param("eTown") ETown town);

    @Query("SELECT re FROM RealEstate re " +
            "WHERE re.numberOfRooms = :numberOfRooms " +
            "AND re.floorNo = :floorNo " +
            "AND re.squareMeters = :squareMeters " +
            "AND re.eRealEstateType = :eRealEstateType " +
            "AND re.eSaleOrRent = :eSaleOrRent " +
            "AND re.eTown = :eTown")
    List<RealEstate> findRealEstatesByItsProperties(@Param("numberOfRooms") int numberOfRooms,
                                                    @Param("floorNo") int floorNo,
                                                    @Param("squareMeters") int squareMeters,
                                                    @Param("eRealEstateType") ERealEstateType realEstateType,
                                                    @Param("eSaleOrRent") ESaleOrRent saleOrRent,
                                                    @Param("eTown") ETown town);


//    @Query("SELECT re FROM RealEstate re WHERE re.eTown = :eTown")
//    List<RealEstate> searchByTown(@Param("eTown") ETown eTown);

}

