package com.example.demo.services.imp;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Prices;
import com.example.demo.repository.PricesRepository;
import com.example.demo.services.MainService;

@Service
public class MainServiceImp implements MainService {
	
	@Autowired
	private PricesRepository pricesRepository;

	@Override
	public ArrayList<Prices> getPrices(Date fecha, Integer identificador, Integer cadena) {
		
		ArrayList<Prices> listPrices = new ArrayList();
		
		listPrices = pricesRepository.getPrices(fecha, identificador, cadena);
		
		return listPrices;
	}

}
