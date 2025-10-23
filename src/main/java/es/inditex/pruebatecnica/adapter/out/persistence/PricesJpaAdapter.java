package es.inditex.pruebatecnica.adapter.out.persistence;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import es.inditex.pruebatecnica.application.port.out.PricesPersistencePort;
import es.inditex.pruebatecnica.domain.Prices;

@Component
public class PricesJpaAdapter implements PricesPersistencePort {

    private final PricesRepository pricesRepository;

    public PricesJpaAdapter(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public List<Prices> getPrices(Date fecha, Integer identificador, Integer cadena) {
        return pricesRepository.getPrices(fecha, identificador, cadena)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Prices toDomain(PricesEntity entity) {
        return Prices.builder()
                .id(entity.getId())
                .brandId(entity.getBrandId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .productId(entity.getProductId())
                .priority(entity.getPriority())
                .price(entity.getPrice())
                .curr(entity.getCurr())
                .build();
    }

    private PricesEntity toEntity(Prices domain) {
        return PricesEntity.builder()
                .id(domain.getId())
                .brandId(domain.getBrandId())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .priceList(domain.getPriceList())
                .productId(domain.getProductId())
                .priority(domain.getPriority())
                .price(domain.getPrice())
                .curr(domain.getCurr())
                .build();
    }
}