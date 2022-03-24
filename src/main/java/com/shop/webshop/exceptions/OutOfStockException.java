package com.shop.webshop.exceptions;

public class OutOfStockException extends RuntimeException{
    public OutOfStockException() {
        super("Out of stock");
    }
}
