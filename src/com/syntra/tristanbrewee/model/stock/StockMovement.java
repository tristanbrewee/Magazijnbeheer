package com.syntra.tristanbrewee.model.stock;

public enum StockMovement {

    IN_BUY("IN", "BUY"), IN_PRODUCTION("IN", "PRODUCE"),
    OUT_SELL("OUT", "SELL"), OUT_RELOCATE("OUT", "RELOCATE"), OUT_REMOVE("OUT", "REMOVE");

    private String direction;
    private String action;

    StockMovement(String direction, String action){
        this.direction = direction;
        this.action = action;
    }

    public String getDirection() {
        return direction;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString(){
        return getDirection() + "." + getAction();
    }
}
