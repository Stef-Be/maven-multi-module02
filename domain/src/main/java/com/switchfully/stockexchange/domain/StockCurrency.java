package com.switchfully.stockexchange.domain;

public enum StockCurrency {
    EUR(" Euro", "€"),
    USD(" Dollar", "$"),
    GBP(" Pound", "£");

    private String label;
    private String symbol;

    StockCurrency(String label, String symbol) {
        this.label = label;
        this.symbol = symbol;
    }

    public String getLabel() {
        return label;
    }
}
