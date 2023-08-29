package com.peugeot.service.impl;

import com.peugeot.dto.OrderDto;
import com.peugeot.exception.ClientNotFoundException;
import com.peugeot.exception.OrderNotFoundException;
import com.peugeot.model.Client;
import com.peugeot.model.Order;
import com.peugeot.repository.ClientRepository;
import com.peugeot.repository.OrderRepository;
import com.peugeot.service.OrderService;
import com.peugeot.utils.EntityDtoConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(EntityDtoConvertor::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Integer id) {
        //cautam comanda dupa id in repo si daca nu gaseste arunca exceptia cum ca nu s-a gasit in baza de date
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        return EntityDtoConvertor.toDto(order);
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        // order este DTO si convertim la entitate ca sa putem sa salvam in baza de date
        Order order = EntityDtoConvertor.toEntity(orderDto);

        //salvam entitatea in Order -> save se face pe entitate nu pe dto
        Order savedOrder = orderRepository.save(order);

        //convertim entitatea in dto
        return EntityDtoConvertor.toDto(savedOrder);
    }

    @Override
    public OrderDto updateOrderById(OrderDto orderDto, Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        order.setDate_order(LocalDate.now());
        order.setOrder_name(orderDto.getOrder_name());
        order.setOrder_no(order.getOrder_no());
        order.setQuantity(order.getQuantity());
        Order updatedOrder = orderRepository.save(order);

        return EntityDtoConvertor.toDto(updatedOrder);
    }

    @Override
    public void deleteOrderById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        orderRepository.deleteById(id);
    }

    @Override
    public String assignClient(Integer clientId, Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order %s not found", orderId)));

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(String.format("Client %s not found", clientId)));

        order.setClient(client);
        orderRepository.save(order);
        return String.format("Order %s has been assigned to client %s %s", order.getOrder_name(), client.getFirstName(), client.getLastName());
    }
}
