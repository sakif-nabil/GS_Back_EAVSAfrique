package com.hamzaTech.gestionstock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hamzaTech.gestionstock.entities.Bon;
import com.hamzaTech.gestionstock.services.GenerateBonWord;

@SpringBootApplication
public class GestionstockApplication implements CommandLineRunner {

	@Autowired
	GenerateBonWord generateBonWord;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionstockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//generateBonWord.generatePdf(new Bon());
		
	}

}
