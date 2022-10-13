package com.switchfully.stockexchange.cli;

import com.switchfully.stockexchange.api.StockDTO;
import com.switchfully.stockexchange.api.StockExchangeController;
import com.switchfully.stockexchange.api.StockMapper;
import com.switchfully.stockexchange.service.StockService;


public class MyCLI {
    public static void main(String[] args) {
        if (args.length == 1) {
            StockExchangeController controller = new StockExchangeController(new StockService(), new StockMapper());
            StockDTO stockDTO = controller.getStock(args[0]);
            printStockDTO(stockDTO);
        } else {
            System.out.println("No stock with this ID found.");
        }
    }

    private static void printStockDTO(StockDTO stockDTO) {
        System.out.println("Stock with id: " + stockDTO.getId()
                + "\nName: " + stockDTO.getName()
                + "\nPrice: " + stockDTO.getPrice() + stockDTO.getCurrency());
    }
}
