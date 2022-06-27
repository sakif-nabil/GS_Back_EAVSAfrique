package com.hamzaTech.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamzaTech.gestionstock.entities.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
