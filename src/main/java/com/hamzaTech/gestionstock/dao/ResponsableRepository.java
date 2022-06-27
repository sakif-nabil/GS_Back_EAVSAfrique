package com.hamzaTech.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hamzaTech.gestionstock.entities.Responsable;


@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long> {

}
