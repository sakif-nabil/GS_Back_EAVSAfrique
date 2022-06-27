package com.hamzaTech.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hamzaTech.gestionstock.entities.Materiel;


@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long> {

}
