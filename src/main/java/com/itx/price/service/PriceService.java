package com.itx.price.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itx.price.model.Price;
import com.itx.price.model.PriceDTO;
import com.itx.price.repository.PriceRepository;


@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;


    public Optional<PriceDTO> getPrice(Integer productId, Integer brandId, LocalDateTime applicationDate) {
        List<Price> prices = priceRepository
                .findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        productId, brandId, applicationDate, applicationDate);
        
        if (prices.isEmpty()) {
            return Optional.empty();
        } else {
            // Cogemos el index 0 puesto que sera la de mayor prioridad
            Price price = prices.get(0);
            return Optional.of(new PriceDTO(price.getProductId(), price.getBrandId(),
                    price.getPriceList(), price.getStartDate(), price.getEndDate(), price.getPrice()));
        }
    }

}
