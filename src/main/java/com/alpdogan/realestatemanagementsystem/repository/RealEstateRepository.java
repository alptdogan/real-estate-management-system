package com.alpdogan.realestatemanagementsystem.repository;

import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {
}
