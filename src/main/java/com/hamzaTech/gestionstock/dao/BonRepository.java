package com.hamzaTech.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamzaTech.gestionstock.entities.Bon;


@Repository
public interface BonRepository extends JpaRepository<Bon, Long> {

}
