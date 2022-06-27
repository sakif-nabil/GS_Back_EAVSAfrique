package com.hamzaTech.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hamzaTech.gestionstock.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
