package com.hamzaTech.gestionstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


import org.springframework.transaction.annotation.Transactional;

import com.hamzaTech.gestionstock.dao.ClientRepository;
import com.hamzaTech.gestionstock.entities.Client;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	 
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}


	public Client getClientById(Long id) {
		
		return clientRepository.findById(id).get();
	}


	public Client updateClient(Client client) {
		
		return clientRepository.save(client);
	}


	public void deleteClient(Client client) {
		clientRepository.delete(client);
		
	}


	public List<Client> getAllClient() {
		
		return clientRepository.findAll();
	}

}
