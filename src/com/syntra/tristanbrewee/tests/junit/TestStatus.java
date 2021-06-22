package com.syntra.tristanbrewee.tests.junit;

import com.syntra.tristanbrewee.model.products.*;
import com.syntra.tristanbrewee.model.statuses.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStatus {
    private Product testProduct;

    @BeforeEach
    public void setUp() {
        testProduct = new Book(250, 1000);
    }

    @AfterEach
    public void tearDown() {
        testProduct = null;
    }

    //Buy() stock
    @Test
    public void testStockBuyCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(10);
        assertTrue(testProduct.getCurrentStock() == 110);
    }

    @Test
    public void testStockBuyLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.buy(10);
        assertTrue(testProduct.getCurrentStock() == 210);
    }

    @Test
    public void testStockBuyNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.buy(10);
        assertTrue(testProduct.getCurrentStock() == 510);
    }

    @Test
    public void testStockBuyStockHigh(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.buy(10);
        assertTrue(testProduct.getCurrentStock() == 1000);
    }

    //Buy() status CRITICAL
    @Test
    public void testStatusBuyCriticalStillCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(10);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    @Test
    public void testStatusBuyCriticalToLow(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(100);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusBuyCriticalToNormal(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(400);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusBuyCriticalToHigh(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(5000);
        assertTrue(testProduct.getStatus().equals(new High()));
    }

    //Buy() status LOW
    @Test
    public void testStatusBuyLowStillLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.buy(10);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusBuyLowToNormal(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.buy(300);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusBuyLowToHigh(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.buy(5000);
        assertTrue(testProduct.getStatus().equals(new High()));
    }

    //Buy() status NORMAL
    @Test
    public void testStatusBuyNormalStillNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.buy(10);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusBuyNormalToHigh(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.buy(5000);
        assertTrue(testProduct.getStatus().equals(new High()));
    }

    //Buy() status HIGH
    @Test
    public void testStatusBuyHighStillHigh(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.buy(10);
        assertTrue(testProduct.getStatus().equals(new High()));
    }

    //-----------------------------------
    //Produce() stock
    @Test
    public void testStockProduceCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(10);
        assertTrue(testProduct.getCurrentStock() == 110);
    }

    @Test
    public void testStockProduceLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.produce(10);
        assertTrue(testProduct.getCurrentStock() == 210);
    }

    @Test
    public void testStockProduceNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.produce(10);
        assertTrue(testProduct.getCurrentStock() == 510);
    }

    @Test
    public void testStockProduceStockHigh(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.produce(10);
        assertTrue(testProduct.getCurrentStock() == 1000);
    }

    //Produce() status CRITICAL
    @Test
    public void testStatusProduceCriticalStillCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(10);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    @Test
    public void testStatusProduceCriticalToLow(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(100);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusProduceCriticalToNormal(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(400);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusProduceCriticalToHigh(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(5000);
        assertTrue(testProduct.getStatus().equals(new High()));
    }

    //Produce() status LOW
    @Test
    public void testStatusProduceLowStillLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.produce(10);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusProduceLowToNormal(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.produce(300);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusProduceLowToHigh(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.produce(5000);
        assertTrue(testProduct.getStatus().equals(new High()));
    }

    //Produce() status NORMAL
    @Test
    public void testStatusProduceNormalStillNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.produce(10);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusProduceNormalToHigh(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.produce(5000);
        assertTrue(testProduct.getStatus().equals(new High()));
    }

    //Produce() status HIGH
    @Test
    public void testStatusProduceHighStillHigh(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.produce(10);
        assertTrue(testProduct.getStatus().equals(new High()));
    }

    //-----------------------------------
    //Remove() stock
    @Test
    public void testStockRemoveCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.remove(10);
        assertTrue(testProduct.getCurrentStock() == 100);
    }

    @Test
    public void testStockRemoveLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.remove(10);
        assertTrue(testProduct.getCurrentStock() == 190);
    }

    @Test
    public void testStockRemoveNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.remove(10);
        assertTrue(testProduct.getCurrentStock() == 490);
    }

    @Test
    public void testStockRemoveStockHigh(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.remove(10);
        assertTrue(testProduct.getCurrentStock() == 990);
    }

    //Remove() status CRITICAL
    @Test
    public void testStatusRemoveCriticalStillCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.remove(10);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Remove() status Low
    @Test
    public void testStatusRemoveLowStillLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.remove(10);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusRemoveLowToCritical(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.remove(200);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Remove() status NORMAL
    @Test
    public void testStatusRemoveNormalStillNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.remove(10);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusRemoveNormalToLow(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.remove(300);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusRemoveNormalToCritical(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.remove(400);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Remove() status HIGH
    @Test
    public void testStatusRemoveHighToNormal(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.remove(400);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusRemoveHighToLow(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.remove(800);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusRemoveHighToCritical(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.remove(900);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //-----------------------------------
    //Sell() stock
    @Test
    public void testStockSellCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.sell(10);
        assertTrue(testProduct.getCurrentStock() == 100);
    }

    @Test
    public void testStockSellLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.sell(10);
        assertTrue(testProduct.getCurrentStock() == 190);
    }

    @Test
    public void testStockSellNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.sell(10);
        assertTrue(testProduct.getCurrentStock() == 490);
    }

    @Test
    public void testStockSellStockHigh(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.sell(10);
        assertTrue(testProduct.getCurrentStock() == 990);
    }

    //Sell() status CRITICAL
    @Test
    public void testStatusSellCriticalStillCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.sell(10);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Sell() status Low
    @Test
    public void testStatusSellLowStillLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.sell(10);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusSellLowToCritical(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.sell(200);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Sell() status NORMAL
    @Test
    public void testStatusSellNormalStillNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.sell(10);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusSellNormalToLow(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.sell(300);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusSellNormalToCritical(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.sell(400);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Sell() status HIGH
    @Test
    public void testStatusSellHighToNormal(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.sell(400);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusSellHighToLow(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.sell(800);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusSellHighToCritical(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.sell(900);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //-----------------------------------
    //Relocate() stock
    @Test
    public void testStockRelocateCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.relocate(10);
        assertTrue(testProduct.getCurrentStock() == 100);
    }

    @Test
    public void testStockRelocateLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.relocate(10);
        assertTrue(testProduct.getCurrentStock() == 190);
    }

    @Test
    public void testStockRelocateNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.relocate(10);
        assertTrue(testProduct.getCurrentStock() == 490);
    }

    @Test
    public void testStockRelocateStockHigh(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.relocate(10);
        assertTrue(testProduct.getCurrentStock() == 990);
    }

    //Relocate() status CRITICAL
    @Test
    public void testStatusRelocateCriticalStillCritical(){
        setStockToHundredAndStatusToCritical(testProduct);
        testProduct.relocate(10);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Relocate() status Low
    @Test
    public void testStatusRelocateLowStillLow(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.relocate(10);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusRelocateLowToCritical(){
        setStockToTwoHundredAndStatusToLow(testProduct);
        testProduct.relocate(200);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Relocate() status NORMAL
    @Test
    public void testStatusRelocateNormalStillNormal(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.relocate(10);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusRelocateNormalToLow(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.relocate(300);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusRelocateNormalToCritical(){
        setStockToFiveHundredAndStatusToNormal(testProduct);
        testProduct.relocate(400);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //Relocate() status HIGH
    @Test
    public void testStatusRelocateHighToNormal(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.relocate(400);
        assertTrue(testProduct.getStatus().equals(new Normal()));
    }

    @Test
    public void testStatusRelocateHighToLow(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.relocate(800);
        assertTrue(testProduct.getStatus().equals(new Low()));
    }

    @Test
    public void testStatusRelocateHighToCritical(){
        setStockToThousandAndStatusToHigh(testProduct);
        testProduct.relocate(900);
        assertTrue(testProduct.getStatus().equals(new Critical()));
    }

    //-----------------------------------
    //Utils
    private void setStockToHundredAndStatusToCritical(Product product){
        product.buy(1000);
        product.sell(900);
    }

    private void setStockToTwoHundredAndStatusToLow(Product product){
        product.buy(1000);
        product.sell(800);
    }

    private void setStockToFiveHundredAndStatusToNormal(Product product){
        product.buy(1000);
        product.sell(500);
    }

    private void setStockToThousandAndStatusToHigh(Product product){
        product.buy(1000);
    }
}
