package com.itx.price.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itx.price.model.Price;


public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
        Integer productId, Integer brandId, LocalDateTime date, LocalDateTime dateEnd);

}
