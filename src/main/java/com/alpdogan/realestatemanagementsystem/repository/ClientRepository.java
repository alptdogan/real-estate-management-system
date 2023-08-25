package com.alpdogan.realestatemanagementsystem.repository;

import com.alpdogan.realestatemanagementsystem.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
