package com.syntra.tristanbrewee.model.statuses;

import com.syntra.tristanbrewee.model.products.Product;
import com.syntra.tristanbrewee.model.stock.Stock;
import com.syntra.tristanbrewee.model.stock.StockMovement;

public class High extends Status {

    public High(){
        statusDescription = StatusDescription.HIGH;
    }

    @Override
    public void buy(Product product, int amount) {
        product.addStock(new Stock(StockMovement.IN_BUY, false, amount));
        printWarning("buy");
    }

    @Override
    public void produce(Product product, int amount) {
        product.addStock(new Stock(StockMovement.IN_PRODUCTION, false, amount));
        printWarning("produce");
    }

    private void printWarning(String action){
        System.out.println("--> Status " + statusDescription.toString() + "! Didn't " + action + " anything.");
    }
}
