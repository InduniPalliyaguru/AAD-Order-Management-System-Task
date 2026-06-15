package com.ijse.taskAAD.service;

import com.ijse.taskAAD.dto.FilterOrderDTO;
import com.ijse.taskAAD.dto.PlaceOrderDTO;

import java.util.List;

public interface OrderService {

    void placeOrder(PlaceOrderDTO placeOrderDTO);

    List<FilterOrderDTO> filterOrders(String customerName);

}
