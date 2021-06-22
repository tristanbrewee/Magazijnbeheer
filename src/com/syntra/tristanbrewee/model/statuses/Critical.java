package com.syntra.tristanbrewee.model.statuses;

import com.syntra.tristanbrewee.model.products.Product;
import com.syntra.tristanbrewee.model.stock.*;

public class Critical extends Status {

    public Critical(){
        this.statusDescription = StatusDescription.CRITICAL;
    }

    @Override
    public void sell(Product product, int amount) {
        product.addStock(new Stock(StockMovement.OUT_SELL, false, amount));
        printWarning("sell");
    }

    @Override
    public void relocate(Product product, int amount) {
        product.addStock(new Stock(StockMovement.OUT_RELOCATE, false, amount));
        printWarning("relocate");
    }

    @Override
    public void remove(Product product, int amount) {
        product.addStock(new Stock(StockMovement.OUT_REMOVE, false, amount));
        printWarning("remove");
    }

    private void printWarning(String action){
        System.out.println("--> Status " + statusDescription.toString() + "! Didn't " + action + " anything.");
    }
}
