package com.syntra.tristanbrewee.factories;

import com.syntra.tristanbrewee.model.stock.*;

public class StockMovementFactory {

    private static StockMovementFactory instance = new StockMovementFactory();

    private StockMovementFactory(){
    }

    public static StockMovementFactory getInstance(){
        return instance;
    }

    public StockMovement createStockMovement(int choice){
        StockMovement[] stockMovements = StockMovement.values();
        return stockMovements[choice];
    }

    public StockMovement createRandomStockMovement(){
        int choice = (int)(Math.random() * StockMovement.values().length );
        return createStockMovement(choice);
    }
}
