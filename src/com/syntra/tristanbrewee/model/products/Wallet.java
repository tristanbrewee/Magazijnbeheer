package com.syntra.tristanbrewee.model.products;

public class Wallet extends Product{

    public Wallet(int amountLow, int amountHigh){
        super(amountLow, amountHigh);
        this.name = "Wallet";
    }
}