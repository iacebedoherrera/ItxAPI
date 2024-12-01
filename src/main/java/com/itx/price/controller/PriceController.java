package com.itx.price.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itx.price.model.PriceDTO;
import com.itx.price.service.PriceService;

@RestController
@RequestMapping("/api")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/prices")
    public ResponseEntity<PriceDTO> getPrice(
        @RequestParam Integer productId,
        @RequestParam Integer brandId,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {
        
        Optional<PriceDTO> priceDTO = priceService.getPrice(productId, brandId, applicationDate);
        
        return priceDTO
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
