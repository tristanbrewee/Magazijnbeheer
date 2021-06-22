package com.syntra.tristanbrewee.tests.junit;

import com.syntra.tristanbrewee.factories.StockMovementFactory;
import com.syntra.tristanbrewee.model.stock.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStockMovementFactory {

    private StockMovementFactory stockMovementFactory;
    private StockMovement testStockMovement;

    @BeforeEach
    public void setUp(){
        stockMovementFactory = StockMovementFactory.getInstance();
    }

    @AfterEach
    public void tearDown(){
        stockMovementFactory = null;
        testStockMovement = null;
    }

    @Test
    public void testSingleton(){
        assertTrue(stockMovementFactory.equals(StockMovementFactory.getInstance()));
    }

    @Test
    public void testCreateStockInBuy(){
        testStockMovement = stockMovementFactory.createStockMovement(0);
        assertTrue(testStockMovement.equals(StockMovement.IN_BUY));
    }

    @Test
    public void testCreateStockInProduction(){
        testStockMovement = stockMovementFactory.createStockMovement(1);
        assertTrue(testStockMovement.equals(StockMovement.IN_PRODUCTION));
    }

    @Test
    public void testCreateStockOutSell(){
        testStockMovement = stockMovementFactory.createStockMovement(2);
        assertTrue(testStockMovement.equals(StockMovement.OUT_SELL));
    }

    @Test
    public void testCreateStockOutRelocate(){
        testStockMovement = stockMovementFactory.createStockMovement(3);
        assertTrue(testStockMovement.equals(StockMovement.OUT_RELOCATE));
    }

    @Test
    public void testCreateStockOutRemove(){
        testStockMovement = stockMovementFactory.createStockMovement(4);
        assertTrue(testStockMovement.equals(StockMovement.OUT_REMOVE));
    }

    @Test
    public void testCreateRandomStock(){
        testStockMovement = stockMovementFactory.createRandomStockMovement();
        assertTrue(testStockMovement instanceof  StockMovement);
    }
}
