package com.switchfully.stockexchange.api;

import com.switchfully.stockexchange.domain.Stock;
import com.switchfully.stockexchange.service.StockService;

public class StockExchangeController {
    private StockService stockService;
    private StockMapper stockMapper;

    public StockExchangeController(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    public StockDTO getStock (String stockId){
        Stock stockToDTO = stockService.getStock(stockId);
        return stockMapper.mapToDTO(stockToDTO);
    }
}
