package es.inditex.pruebatecnica.adapter.out.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Long>{

	@Query("select p from PricesEntity p where p.productId = :identificador and p.brandId = :cadena and p.startDate < :fecha and p.endDate > :fecha order by p.priority desc")
	List<PricesEntity> getPrices(@Param(value = "fecha") Date fecha, @Param(value="identificador") Integer identificador, @Param(value="cadena") Integer cadena);
	
}