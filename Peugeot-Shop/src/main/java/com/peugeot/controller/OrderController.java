package com.peugeot.controller;

import com.peugeot.dto.OrderDto;
import com.peugeot.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto){

        OrderDto savedOrder = orderService.saveOrder(orderDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("message", "Order created successfully.")
                .body(savedOrder);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("orderId") Integer orderId){
        OrderDto orderById = orderService.getOrderById(orderId);
        return new ResponseEntity<>(orderById, HttpStatus.OK);
    }

    @PutMapping("/updateOrderById/{orderId}")
    public ResponseEntity<OrderDto> updateOrderById(@PathVariable("orderId") Integer orderId,
                                                    @RequestBody OrderDto orderDto){
        OrderDto updatedOrder = orderService.updateOrderById(orderDto, orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("message", "Order updated successfully")
                .body(updatedOrder);
    }

    @DeleteMapping("/deleteOrderById/{orderId}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable("orderId") Integer orderId){
        orderService.deleteOrderById(orderId);
        return ResponseEntity
                .noContent()
                .header("message", "Order deleted successfully")
                .build();
    }

    @GetMapping("/assignClient")
    public ResponseEntity<String> assignClient(@RequestParam Integer clientId,
                                               @RequestParam Integer orderId){
        return ResponseEntity.ok(orderService.assignClient(clientId, orderId));
    }
}
