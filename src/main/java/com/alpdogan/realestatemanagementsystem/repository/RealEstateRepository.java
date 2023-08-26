package com.alpdogan.realestatemanagementsystem.repository;

import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {

    @Query("SELECT re FROM RealEstate re WHERE re.numberOfRooms = :numberOfRooms")
    List<RealEstate> searchByNumberOfRooms(@Param("numberOfRooms") int numberOfRooms);

}
