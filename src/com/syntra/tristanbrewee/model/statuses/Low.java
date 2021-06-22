package com.syntra.tristanbrewee.model.statuses;

import com.syntra.tristanbrewee.model.products.Product;

public class Low extends Status {

    public Low(){
        statusDescription = StatusDescription.LOW;
    }

    @Override
    public void sell(Product product, int amount) {
        outWarning();
        super.sell(product, amount);
    }

    @Override
    public void relocate(Product product, int amount) {
        outWarning();
        super.relocate(product, amount);
    }

    @Override
    public void remove(Product product, int amount) {
        outWarning();
        super.remove(product, amount);
    }

    private void outWarning(){
        System.out.println("-----> Status: " + statusDescription.toString() + "! Need to produce/buy soon! <-----");
    }
}
