package es.inditex.pruebatecnica.adapter.in.web;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.inditex.pruebatecnica.application.port.in.MainService;
import es.inditex.pruebatecnica.domain.Prices;

@RestController
@RequestMapping("/api")
public class MainController {

	private MainService mainService;
	
	public MainController(MainService mainService) {
        this.mainService = mainService;
    }

	@GetMapping("/getPrices")
	public ResponseEntity<List<Prices>> getPrices(
	        @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fecha,
	        @RequestParam Integer identificador,
	        @RequestParam Integer cadena) {

        List<Prices> listPrices = mainService.getPrices(fecha, identificador, cadena);
        return new ResponseEntity<>(listPrices, HttpStatus.OK);
    }

}