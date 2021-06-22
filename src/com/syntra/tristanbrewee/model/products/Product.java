package com.syntra.tristanbrewee.model.products;

import com.syntra.tristanbrewee.model.statuses.*;
import com.syntra.tristanbrewee.model.stock.Stock;
import com.syntra.tristanbrewee.model.stock.StockMovement;

import java.util.LinkedList;

public abstract class Product implements Comparable<Product>{

    protected String name;
    private LinkedList<Stock> stocks = new LinkedList<>();
    private Status status;
    private int initialStock;

    public final int AMOUNT_LOW;
    public final int AMOUNT_HIGH;
    public final int AMOUNT_CRITICAL;

    //Constructor
    public Product(int amountLow, int amountHigh){
        AMOUNT_LOW = amountLow;
        AMOUNT_HIGH = amountHigh;
        AMOUNT_CRITICAL = AMOUNT_LOW / 2;
        initialStock = AMOUNT_LOW + 1 + (int)(Math.random() * (AMOUNT_HIGH - 1)); //A number between (and excluding) AMOUNT_LOW and AMOUNT_HIGH
        status = new Normal();
    }

    //Methods
    public void buy(int amount){
        status.buy(this, amount);
    }

    public void produce(int amount){
        status.produce(this, amount);
    }

    public void sell(int amount){
        status.sell(this, amount);
    }

    public void remove(int amount){
        status.remove(this, amount);
    }

    public void relocate(int amount){
        status.relocate(this, amount);
    }

    public int getCurrentStock(){
        int currentStock = initialStock;
        for (Stock stock : stocks){
            if (stock.isHasHappened()){
                if (stock.getStockMovement().equals(StockMovement.IN_BUY)
                        || stock.getStockMovement().equals(StockMovement.IN_PRODUCTION))
                    currentStock += stock.getAmount();
                else
                    currentStock -= stock.getAmount();
            }
        }
        return currentStock;
    }

    public int getFreeSpace(){
        return AMOUNT_HIGH - getCurrentStock();
    }

    public void addStock(Stock stock){
        stocks.add(stock);
    }

    //Setters
    public void setStatus(Status status) {
        this.status = status;
    }

    //Getters
    public String getName() {
        return name;
    }

    public LinkedList<Stock> getStocks() {
        return stocks;
    }

    public Status getStatus() {
        return status;
    }

    public int getInitialStock() {
        return initialStock;
    }

    //Overrides
    @Override
    public String toString(){
        String allStockValidations = "";
        for (Stock stock: stocks){
            if (!allStockValidations.isEmpty())
                allStockValidations += "\n";
            allStockValidations += "\t\t";
            allStockValidations += stock.toString();
        }
        return name + ":\n" +
                "\tCritical: " + AMOUNT_CRITICAL + "; LOW: " + AMOUNT_LOW + "; HIGH: " + AMOUNT_HIGH +";\n" +
                "\tCurrent stock: " + getCurrentStock() + "\n" +
                "\tStatus: " + status.toString() + "\n" +
                allStockValidations;
    }

    @Override
    public int compareTo(Product product){
        return name.compareTo(product.getName());
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof Product)
            return this.name.equals(((Product) object).getName());
        return false;
    }
}
