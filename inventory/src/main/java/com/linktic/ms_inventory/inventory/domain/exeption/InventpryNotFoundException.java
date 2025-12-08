package com.linktic.ms_inventory.inventory.domain.exeption;

public class InventpryNotFoundException extends RuntimeException{
    public InventpryNotFoundException(String message){
        super(message);
    }
}
