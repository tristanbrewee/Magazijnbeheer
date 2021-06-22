package com.syntra.tristanbrewee.tests.junit;

import com.syntra.tristanbrewee.model.products.*;
import com.syntra.tristanbrewee.model.statuses.*;
import com.syntra.tristanbrewee.model.stock.Stock;
import com.syntra.tristanbrewee.model.stock.StockMovement;
import org.junit.jupiter.api.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProduct {
    private Product testProduct1;
    private Product testProduct2;

    //TODO ___FIX_EVERY_ERROR_NOW___

    @BeforeEach
    public void setUp(){
        testProduct1 = new Book(250, 1000);
        testProduct1.sell(25);
        testProduct2 = new Chair(10, 50);
    }

    @AfterEach
    public void tearDown(){
        testProduct1 = null;
        testProduct2 = null;
    }

    @Test
    public void testGetCurrentStockNoStocks(){
        Product product = new Book(250, 1000);
        int initialStock = product.getInitialStock();
        assertTrue(initialStock == product.getCurrentStock());
    }

    @Test
    public void testGetCurrentStockWithStocks(){
        testProduct1.buy(20);
        testProduct1.produce(15);
        testProduct1.remove(10);
        testProduct1.relocate(5);
        int currentStock = testProduct1.getInitialStock() - 25 + 20 + 15 - 10 - 5;
        assertTrue(currentStock == testProduct1.getCurrentStock());
    }

    @Test
    public void testGetFreeSpace(){
        int freeSpace = testProduct1.AMOUNT_HIGH - testProduct1.getCurrentStock();
        assertTrue(freeSpace == testProduct1.getFreeSpace());
    }

    @Test
    public void testAddStock(){
        testProduct1.addStock(new Stock(StockMovement.IN_BUY, true, 10));
        assertTrue(testProduct1.getStocks().size() == 2);
    }

    @Test
    public void testSetStatus(){
        testProduct1.setStatus(new Critical());
        assertTrue(testProduct1.getStatus().equals(new Critical()));
    }

    @Test
    public void testGetName(){
        assertTrue(testProduct1.getName().equals("Book"));
    }

    @Test
    public void testGetStocks(){
        LinkedList<Stock> stockMovements = new LinkedList<>();
        for (Stock stock: testProduct1.getStocks())
            stockMovements.add(stock);
        assertTrue(testProduct1.getStocks().equals(stockMovements));
    }

    @Test
    public void testGetStatus(){
        testProduct1.setStatus(new Critical());
        assertTrue(testProduct1.getStatus().equals(new Critical()));
    }

    @Test
    public void testGetInitialStock(){
        int initialStock = testProduct1.getCurrentStock() + 25;
        assertTrue(testProduct1.getInitialStock() == initialStock);
    }

    @Test
    public void testToString(){
        String allStockValidations = "";
        for (Stock stock: testProduct1.getStocks()){
            if (!allStockValidations.isEmpty())
                allStockValidations += "\n";
            allStockValidations += "\t\t";
            allStockValidations += stock.toString();
        }
        String toString = "Book:\n\tCritical: " + testProduct1.AMOUNT_CRITICAL + "; LOW: " + testProduct1.AMOUNT_LOW +
                "; HIGH: " + testProduct1.AMOUNT_HIGH + ";\n" +
                "\tCurrent stock: " + testProduct1.getCurrentStock() + "\n\tStatus: " + testProduct1.getStatus().toString() +
                "\n" + allStockValidations;
        assertTrue(testProduct1.toString().equals(toString));
    }

    @Test
    public void testCompareToMinusOne(){
        assertTrue(-1 == testProduct1.compareTo(testProduct2));
    }

    @Test
    public void testCompareToZero(){
        assertTrue(0 == testProduct1.compareTo(testProduct1));
    }

    @Test
    public void testCompareToOne(){
        assertTrue(1 == testProduct2.compareTo(testProduct1));
    }
}
