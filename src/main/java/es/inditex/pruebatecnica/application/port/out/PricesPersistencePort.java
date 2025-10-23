package es.inditex.pruebatecnica.application.port.out;

import java.util.Date;
import java.util.List;

import es.inditex.pruebatecnica.domain.Prices;

public interface PricesPersistencePort {
	
	List<Prices> getPrices(Date fecha, Integer identificador, Integer cadena);

}
