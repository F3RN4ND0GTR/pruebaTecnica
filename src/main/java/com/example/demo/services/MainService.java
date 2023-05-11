package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Prices;

public interface MainService {

	ArrayList<Prices> getPrices(Date fecha, Integer identificador, Integer cadena);

}
