package com.hamzaTech.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hamzaTech.gestionstock.entities.Categorie;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
