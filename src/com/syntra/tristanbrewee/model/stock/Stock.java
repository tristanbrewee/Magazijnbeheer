package com.syntra.tristanbrewee.model.stock;

public class Stock {

    private StockMovement stockMovement;
    private int amount;
    private boolean hasHappened;

    public Stock(StockMovement stockMovement, boolean hasHappened, int amount){
        this.stockMovement = stockMovement;
        this.hasHappened = hasHappened;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public StockMovement getStockMovement(){
        return stockMovement;
    }

    public boolean isHasHappened(){
        return hasHappened;
    }

    @Override
    public String toString(){
        return stockMovement.toString() +
                ": " + amount + "; has happened: " + hasHappened;
    }
}
