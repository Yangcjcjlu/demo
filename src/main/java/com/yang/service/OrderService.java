package com.yang.service;

import com.yang.model.Order;

public interface OrderService {

    Order createOrder(String userName, String product);

    Order queryOrder(String userName);
}
