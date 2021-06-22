package com.syntra.tristanbrewee.tests.junit;

import com.syntra.tristanbrewee.model.stock.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStock {
    private Stock stock;

    @BeforeEach
    public void setUp(){
        StockMovement stockMovement = StockMovement.IN_BUY;
        stock = new Stock(stockMovement, true, 50);
    }

    @AfterEach
    public void tearDown(){
        stock = null;
    }

    @Test
    public void testGetAmount(){
        assertTrue(stock.getAmount() == 50);
    }

    @Test
    public void testGetStockMovement(){
        assertTrue(stock.getStockMovement() == (StockMovement.IN_BUY));
    }

    @Test
    public void testIsHasHappened(){
        assertTrue(stock.isHasHappened());
    }

    @Test
    public void testToString(){
        assertTrue(stock.toString().equalsIgnoreCase(stock.getStockMovement().toString() +
                ": " + stock.getAmount() + "; has happened: " + stock.isHasHappened()));
    }
}
