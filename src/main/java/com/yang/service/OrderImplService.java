package com.yang.service;

import com.yang.model.Order;

public class OrderImplService implements OrderService {

    public static Order order = null;


    @Override
    public Order createOrder(String userName, String product) {
        order = new Order();
        order.setProduct(product);
        order.setUserName(userName);
        return order;
    }

    @Override
    public Order queryOrder(String userName) {
        return order;
    }
}
