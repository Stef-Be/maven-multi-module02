package com.switchfully.stockexchange.api;

import com.switchfully.stockexchange.domain.Stock;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StockMapper {
    public StockDTO mapToDTO(Stock stock) {
        if (stock.getPrice() == null) {
            return new StockDTO(
                    stock.getId(),
                    stock.getName(),
                    stock.getPrice().getPrice(),
                    stock.getPrice().getCurrency().getLabel());
        } else {
            return new StockDTO(
                    stock.getId(),
                    stock.getName(),
                    new BigDecimal(0),
                    "Unknown stock");
        }
    }
}
