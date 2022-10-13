package com.switchfully.stockexchange.domain;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public class StockRepository {
    private static final Map<String, Stock> stockMap = Maps.newHashMap(new ImmutableMap.Builder<String, Stock>()
            .put("AA", new Stock("AA", "AMRO AN"))
            .put("BTC", new Stock("BTC", "Bitcoin"))
            .put("TSL", new Stock("TSL", "Tesla"))
            .put("VWCE", new Stock("VWCE", "Vanguard All World")).build());

    public static Stock getStockInformation(String stockId) throws IllegalArgumentException{
        if (stockMap.containsKey(stockId)) {
            return stockMap.get(stockId);
        } else {
            throw new IllegalArgumentException("No stock found for id: " + stockId);
        }
    }
}
