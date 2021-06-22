package com.syntra.tristanbrewee.model.statuses;

import com.syntra.tristanbrewee.model.products.*;
import com.syntra.tristanbrewee.model.stock.*;

public abstract class Status {

    protected StatusDescription statusDescription;

    public void buy(Product product, int amount){
        if (amount <= product.getFreeSpace()) {
            product.addStock(new Stock(StockMovement.IN_BUY, true, amount));
            System.out.println("--> Bought x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getFreeSpace();
            product.addStock(new Stock(StockMovement.IN_BUY, true, newAmount));
            System.out.println("--> Bought x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }
    public void produce(Product product, int amount){
        if (amount <= product.getFreeSpace()) {
            product.addStock(new Stock(StockMovement.IN_PRODUCTION, true, amount));
            System.out.println("--> Produced x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getFreeSpace();
            product.addStock(new Stock(StockMovement.IN_PRODUCTION, true, newAmount));
            System.out.println("--> Produced x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }

    public void sell(Product product, int amount){
        if (amount <= product.getCurrentStock()){
            product.addStock(new Stock(StockMovement.OUT_SELL, true, amount));
            System.out.println("--> Sold x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getCurrentStock();
            product.addStock(new Stock(StockMovement.OUT_SELL, true, newAmount));
            System.out.println("--> Sold x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }
    public void relocate(Product product, int amount){
        if (amount <= product.getCurrentStock()){
            product.addStock(new Stock(StockMovement.OUT_RELOCATE, true, amount));
            System.out.println("--> Relocated x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getCurrentStock();
            product.addStock(new Stock(StockMovement.OUT_RELOCATE, true, newAmount));
            System.out.println("--> Relocated x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }
    public void remove(Product product, int amount){
        if (amount <= product.getCurrentStock()){
            product.addStock(new Stock(StockMovement.OUT_REMOVE, true, amount));
            System.out.println("--> Removed x" + amount + " " + product.getName() + ".");
        } else {
            int newAmount = product.getCurrentStock();
            product.addStock(new Stock(StockMovement.OUT_REMOVE, true, newAmount));
            System.out.println("--> Removed x" + newAmount + " " + product.getName() + " instead of " + amount + ".");
        }
        product.setStatus(calculateNewState(product));
    }

    private static Status calculateNewState(Product product) {
        if (product.getCurrentStock() <= product.AMOUNT_CRITICAL)
            return new Critical();
        if (product.getCurrentStock() <= product.AMOUNT_LOW)
            return new Low();
        if (product.getCurrentStock() >= product.AMOUNT_HIGH)
            return new High();
        return new Normal();
    }

    @Override
    public String toString(){
        return statusDescription.toString();
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Status)
            return statusDescription.toString().equals(obj.toString());
        return false;
    }
}
