package com.peugeot.service;

import com.peugeot.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Integer id);

    OrderDto saveOrder(OrderDto orderDto);

    OrderDto updateOrderById(OrderDto orderDto, Integer id);

    void deleteOrderById(Integer id);
}
