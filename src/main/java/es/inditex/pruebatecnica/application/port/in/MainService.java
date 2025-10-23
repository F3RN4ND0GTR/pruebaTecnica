package es.inditex.pruebatecnica.application.port.in;

import java.util.List;
import java.util.Date;

import es.inditex.pruebatecnica.domain.Prices;

public interface MainService {

	List<Prices> getPrices(Date fecha, Integer identificador, Integer cadena);

}