package es.inditex.pruebatecnica.application.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import es.inditex.pruebatecnica.application.port.in.MainService;
import es.inditex.pruebatecnica.application.port.out.PricesPersistencePort;
import es.inditex.pruebatecnica.domain.Prices;

@Service
public class MainServiceImpl implements MainService {
	
	private final PricesPersistencePort pricesPersistencePort;

    public MainServiceImpl(PricesPersistencePort pricesPersistencePort) {
        this.pricesPersistencePort = pricesPersistencePort;
    }

    @Override
    public List<Prices> getPrices(Date fecha, Integer identificador, Integer cadena) {
        return new ArrayList<>(pricesPersistencePort.getPrices(fecha, identificador, cadena));
    }

}