package com.switchfully.stockexchange.api;

import com.switchfully.stockexchange.domain.Stock;
import com.switchfully.stockexchange.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockExchangeController {

    @Autowired
    private StockService stockService;
    @Autowired
    private StockMapper stockMapper;

    public StockExchangeController(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    @GetMapping("/{stockId}")
    public StockDTO getStock (@PathVariable String stockId){
        Stock stockToDTO = stockService.getStock(stockId);
        return stockMapper.mapToDTO(stockToDTO);
    }
}
