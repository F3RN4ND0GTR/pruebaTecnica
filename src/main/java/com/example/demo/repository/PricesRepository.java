package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long>{

	@Query("select p from Prices p where p.productId = :identificador and p.brandId = :cadena and p.startDate < :fecha and p.endDate > :fecha order by p.priority desc")
	ArrayList<Prices> getPrices(@Param(value = "fecha") Date fecha, @Param(value="identificador") Integer identificador, @Param(value="cadena") Integer cadena);
	
}
