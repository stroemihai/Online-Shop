package com.peugeot.controller;

import com.peugeot.dto.OrderDto;
import com.peugeot.service.ClientService;
import com.peugeot.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto){
        OrderDto savedOrder = orderService.saveOrder(orderDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("message", "Order created successfully.")
                .body(savedOrder);
    }
//http://localhost:8080/api/v1/orders/getAllOrders
//http://localhost:8080/api/v1/orders/getAllOrders
    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/assignClient")
    public ResponseEntity<String> assignClient(@RequestParam Integer clientId,
                                               @RequestParam Integer orderId){
        return ResponseEntity.ok(orderService.assignClient(clientId, orderId));
    }
}
