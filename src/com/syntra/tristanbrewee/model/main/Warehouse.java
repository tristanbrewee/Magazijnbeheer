package com.syntra.tristanbrewee.model.main;

import com.syntra.tristanbrewee.factories.*;
import com.syntra.tristanbrewee.model.stock.*;
import com.syntra.tristanbrewee.model.products.*;

import java.util.*;

public class Warehouse {

    private static final int MIN_NUMBER_OF_PRODUCTS = 5;
    private static final int MAX_NUMBER_OF_PRODUCTS = 11;
    private static final int MIN_NUMBER_OF_STOCK_MOVEMENTS = 5;
    private static final int MAX_NUMBER_OF_STOCK_MOVEMENTS = 10;

    public static void main(String[] args) {

        SortedSet<Product> products = instantiateProducts();
        generateAndPerformStockMovements(products);
        printProducts(products);
    }

    private static void printProducts(SortedSet<Product> products){
        for (Product product: products)
            System.out.println(product.toString());
    }

    public static void generateAndPerformStockMovements(SortedSet<Product> products){
        StockMovementFactory stockMovementFactory = StockMovementFactory.getInstance();
        for (Product product: products){
            System.out.println(product.toString());
            int numberOfStockMovements = MIN_NUMBER_OF_STOCK_MOVEMENTS + (int)(Math.random() * (MAX_NUMBER_OF_STOCK_MOVEMENTS - MIN_NUMBER_OF_STOCK_MOVEMENTS + 1));
            for (int i = 0; i < numberOfStockMovements; i++){
                StockMovement stockMovement = stockMovementFactory.createRandomStockMovement();
                performStockMovement(product, stockMovement);
                System.out.println();
            }
            System.out.println();
            System.out.println("<><><>--------------------<><><>");
            System.out.println();
        }
    }

    private static void performStockMovement(Product product, StockMovement stockMovement){
        int amount = (int)(Math.random() * (product.AMOUNT_HIGH + 1));
        switch (stockMovement){
            case IN_BUY:
                product.buy(amount);
                break;
            case IN_PRODUCTION:
                product.produce(amount);
                break;
            case OUT_SELL:
                product.sell(amount);
                break;
            case OUT_REMOVE:
                product.remove(amount);
                break;
            case OUT_RELOCATE:
                product.relocate(amount);
                break;
            default:
                break;
        }
    }

    private static SortedSet<Product> instantiateProducts(){
        SortedSet<Product> products = new TreeSet<>();
        ProductFactory productFactory = ProductFactory.getInstance();
        int numberOfProducts = MIN_NUMBER_OF_PRODUCTS + (int)(Math.random() * (MAX_NUMBER_OF_PRODUCTS - MIN_NUMBER_OF_PRODUCTS + 1));
        while (products.size() < numberOfProducts){
            products.add(productFactory.createRandomProduct());
        }
        return products;
    }
}
