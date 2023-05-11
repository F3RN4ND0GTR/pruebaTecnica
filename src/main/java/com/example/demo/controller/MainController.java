/**
 * 
 */
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Prices;
import com.example.demo.services.MainService;

/**
 * @author Usuario
 *
 */
@RestController
public class MainController {

	@Autowired
	private MainService mainService;

	@GetMapping(value = "/getPrices")
	@ResponseBody
	public ResponseEntity<ArrayList<Prices>> getPrices(@RequestParam(required = true) Date fecha,
			@RequestParam(required = true) Integer identificador, @RequestParam(required = true) Integer cadena) {

		ArrayList<Prices> listPrices = new ArrayList<Prices>();

		listPrices = mainService.getPrices(fecha, identificador, cadena);

		return new ResponseEntity<>(listPrices, HttpStatus.OK);

	}

}
