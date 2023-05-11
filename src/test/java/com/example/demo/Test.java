package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.demo.entity.Prices;
import com.example.demo.services.MainService;

@SpringBootTest
class Test {
	
	@Autowired
	private MainService mainService;

	@org.junit.jupiter.api.Test
	@Sql(scripts = {"/schema.sql", "/test_data.sql"})
	void testGetPrices1() {
		//Seteamos la fecha a 14 de Junio de 2020 a las 10:00
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date fecha;
		try {
			fecha = format.parse("2020/06/14 10:00:00");
			Integer producto = 35455;
			Integer cadena = 1;
			ArrayList<Prices> listPrices = mainService.getPrices(fecha, producto, cadena);
			
			if(listPrices.size() == 1) {
				Prices aux = listPrices.get(0);
				assertEquals(35.5, aux.getPrice());
			} else {
				fail();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.jupiter.api.Test
	@Sql(scripts = {"/schema.sql", "/test_data.sql"})
	void testGetPrices2() {
		//Seteamos la fecha a 14 de Junio de 2020 a las 16:00
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date fecha;
		try {
			fecha = format.parse("2020/06/14 16:00:00");
			Integer producto = 35455;
			Integer cadena = 1;
			ArrayList<Prices> listPrices = mainService.getPrices(fecha, producto, cadena);
			
			if(listPrices.size() == 2) {
				Prices aux = listPrices.get(0);
				assertEquals(25.45, aux.getPrice());
			} else {
				fail();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.jupiter.api.Test
	@Sql(scripts = {"/schema.sql", "/test_data.sql"})
	void testGetPrices3() {
		//Seteamos la fecha a 14 de Junio de 2020 a las 21:00
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date fecha;
		try {
			fecha = format.parse("2020/06/14 21:00:00");
			Integer producto = 35455;
			Integer cadena = 1;
			ArrayList<Prices> listPrices = mainService.getPrices(fecha, producto, cadena);
			
			if(listPrices.size() == 1) {
				Prices aux = listPrices.get(0);
				assertEquals(35.50, aux.getPrice());
			} else {
				fail();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.jupiter.api.Test
	@Sql(scripts = {"/schema.sql", "/test_data.sql"})
	void testGetPrices4() {
		//Seteamos la fecha a 15 de Junio de 2020 a las 10:00
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date fecha;
		try {
			fecha = format.parse("2020/06/15 10:00:00");
			Integer producto = 35455;
			Integer cadena = 1;
			ArrayList<Prices> listPrices = mainService.getPrices(fecha, producto, cadena);
			
			if(listPrices.size() == 2) {
				Prices aux = listPrices.get(0);
				assertEquals(30.50, aux.getPrice());
			} else {
				fail();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.jupiter.api.Test
	@Sql(scripts = {"/schema.sql", "/test_data.sql"})
	void testGetPrices5() {
		//Seteamos la fecha a 16 de Junio de 2020 a las 21:00
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date fecha;
		try {
			fecha = format.parse("2020/06/16 21:00:00");
			Integer producto = 35455;
			Integer cadena = 1;
			ArrayList<Prices> listPrices = mainService.getPrices(fecha, producto, cadena);
			
			if(listPrices.size() == 2) {
				Prices aux = listPrices.get(0);
				assertEquals(38.95, aux.getPrice());
			} else {
				fail();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
