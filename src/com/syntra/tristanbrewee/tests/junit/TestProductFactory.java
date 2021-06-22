package com.syntra.tristanbrewee.tests.junit;

import com.syntra.tristanbrewee.factories.ProductFactory;
import com.syntra.tristanbrewee.model.products.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProductFactory {

    private Product testProduct;
    private ProductFactory productFactory;

    @BeforeEach
    public void setUp(){
        productFactory = ProductFactory.getInstance();
        testProduct = new Book(250, 1000);
    }

    @AfterEach
    public void tearDown(){
        productFactory = null;
        testProduct = null;
    }

    @Test
    public void testSingleton(){
        assertTrue(productFactory.equals(ProductFactory.getInstance()));
    }

    @Test
    public void testCreateProductBook(){
        String choice = "book";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Book(250, 1000)));
    }

    @Test
    public void testCreateProductChair(){
        String choice = "chair";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Chair(250, 1000)));
    }

    @Test
    public void testCreateProductDesk(){
        String choice = "desk";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Desk(250, 1000)));
    }

    @Test
    public void testCreateProductGlass(){
        String choice = "glass";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Glass(250, 1000)));
    }

    @Test
    public void testCreateProductLaptop(){
        String choice = "laptop";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Laptop(250, 1000)));
    }

    @Test
    public void testCreateProductMonitor(){
        String choice = "monitor";
        testProduct = productFactory.createProduct(choice);
        System.out.println(testProduct);
        assertTrue(testProduct.equals(new Monitor(250, 1000)));
    }

    @Test
    public void testCreateProductMonopoly(){
        String choice = "monopoly";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Monopoly(250, 1000)));
    }

    @Test
    public void testCreateProductMouse(){
        String choice = "mouse";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Mouse(250, 1000)));
    }

    @Test
    public void testCreateProductRazor(){
        String choice = "razor";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Razor(250, 1000)));
    }

    @Test
    public void testCreateProductWallet(){
        String choice = "wallet";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Wallet(250, 1000)));
    }

    @Test
    public void testCreateProductXbox(){
        String choice = "xbox";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct.equals(new Xbox(250, 1000)));
    }

    @Test
    public void testCreateProductNull(){
        String choice = "nothing valid";
        testProduct = productFactory.createProduct(choice);
        assertTrue(testProduct == null);
    }

    @Test
    public void testCreateRandomProduct(){
        testProduct = productFactory.createRandomProduct();
        assertTrue(testProduct instanceof Product);
    }
}
