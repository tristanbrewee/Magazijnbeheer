package com.syntra.tristanbrewee.factories;

import com.syntra.tristanbrewee.model.products.*;

public class ProductFactory {

    private static ProductFactory instance = new ProductFactory();
    private static final int NUMBER_OF_PRODUCT_CLASSES = 11;
    private static final int MIN_BOUNDARY_LOW = 2;
    private static final int MAX_BOUNDARY_LOW = 400;
    private static final int MIN_BOUNDARY_HIGH = 750;
    private static final int MAX_BOUNDARY_HIGH = 1000;

    private ProductFactory(){
    }

    public static ProductFactory getInstance(){
        return instance;
    }

    public Product createProduct(String choice){
        choice = choice.toUpperCase();
        int valueLow = getRandomLowValue();
        int valueHigh = getRandomHighValue();
        switch (choice.toUpperCase()){
            case "BOOK":
                return new Book(valueLow, valueHigh);
            case "CHAIR":
                return new Chair(valueLow, valueHigh);
            case "DESK":
                return new Desk(valueLow, valueHigh);
            case "GLASS":
                return new Glass(valueLow, valueHigh);
            case "LAPTOP":
                return new Laptop(valueLow, valueHigh);
            case "MONITOR":
                return new Monitor(valueLow, valueHigh);
            case "MONOPOLY":
                return new Monopoly(valueLow, valueHigh);
            case "MOUSE":
                return new Mouse(valueLow, valueHigh);
            case "RAZOR":
                return new Razor(valueLow, valueHigh);
            case "WALLET":
                return new Wallet(valueLow, valueHigh);
            case "XBOX":
                return new Xbox(valueLow, valueHigh);
            default:
                return null;
        }
    }

    public Product createRandomProduct(){
        int choiceNumber = (int)(Math.random() * NUMBER_OF_PRODUCT_CLASSES);
        String choiceString;
        switch (choiceNumber){
            case 0:
                choiceString = "BOOK";
                break;
            case 1:
                choiceString = "CHAIR";
                break;
            case 2:
                choiceString = "DESK";
                break;
            case 3:
                choiceString = "GLASS";
                break;
            case 4:
                choiceString = "LAPTOP";
                break;
            case 5:
                choiceString = "MONITOR";
                break;
            case 6:
                choiceString = "MONOPOLY";
                break;
            case 7:
                choiceString = "MOUSE";
                break;
            case 8:
                choiceString = "RAZOR";
                break;
            case 9:
                choiceString = "WALLET";
                break;
            case 10:
                choiceString = "XBOX";
                break;
            default:
                choiceString = null;
                break;
        }
        return createProduct(choiceString);
    }

    private int getRandomLowValue(){
        return MIN_BOUNDARY_LOW + (int)(Math.random() * (MAX_BOUNDARY_LOW + 1 - MIN_BOUNDARY_LOW));
    }

    private int getRandomHighValue(){
        return MIN_BOUNDARY_HIGH + (int)(Math.random() * (MAX_BOUNDARY_HIGH + 1 - MIN_BOUNDARY_HIGH));
    }
}
