package com.syntra.tristanbrewee.model.statuses;

public enum  StatusDescription {

    CRITICAL("CRITICAL"), LOW("LOW"), NORMAL("NORMAL"), HIGH("HIGH");

    private String description;

    StatusDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return getDescription();
    }
}
