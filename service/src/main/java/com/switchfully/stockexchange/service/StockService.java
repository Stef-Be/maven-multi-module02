package com.switchfully.stockexchange.service;


import com.switchfully.stockexchange.domain.Stock;
import com.switchfully.stockexchange.domain.StockCurrency;
import com.switchfully.stockexchange.domain.StockPrice;
import com.switchfully.stockexchange.domain.StockRepository;
import com.switchfully.stockexchange.interfaces.ExternalStockInformationService;

import java.math.BigDecimal;
import java.util.logging.Logger;
import java.util.logging.Level;

public class StockService {

    private static final Logger LOGGER = Logger.getLogger(StockService.class.getName());

    public Stock getStock(String stockId) {
        try {
            Stock stockWithoutPrice = StockRepository.getStockInformation(stockId);
            return enrichStockWithPriceInformation(stockWithoutPrice);
        } catch (IllegalArgumentException ex) {
            LOGGER.log(Level.WARNING, "Stock not found");
            return new Stock(stockId, "Unknown");
        }
    }

    private Stock enrichStockWithPriceInformation(Stock stock) {
        BigDecimal price = ExternalStockInformationService.getPriceInEuroForStock(stock.getId());
        stock.setPrice(new StockPrice(price, StockCurrency.EUR));
        return stock;
    }
}
