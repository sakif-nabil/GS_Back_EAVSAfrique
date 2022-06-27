package com.hamzaTech.gestionstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


import org.springframework.transaction.annotation.Transactional;

import com.hamzaTech.gestionstock.dao.StockRepository;
import com.hamzaTech.gestionstock.entities.Stock;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	 
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Stock createStock(Stock stock) {
		return stockRepository.save(stock);
	}


	public Stock getStockById(Long id) {
		
		return stockRepository.findById(id).get();
	}


	public Stock updateStock(Stock stock) {
		
		return stockRepository.save(stock);
	}


	public void deleteStock(Stock stock) {
		stockRepository.delete(stock);
		
	}


	public List<Stock> getAllStock() {
		
		return stockRepository.findAll();
	}

}
