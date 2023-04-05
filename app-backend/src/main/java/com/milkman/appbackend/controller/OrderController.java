package com.milkman.appbackend.controller;

import com.milkman.appbackend.data.dto.CustomOrderDTO;
import com.milkman.appbackend.data.entity.CustomOrder;
import com.milkman.appbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders/")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("create")
    public ResponseEntity<String> createOrder(@Validated @RequestBody CustomOrder order) {
        try {
            orderService.saveOrder(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Order not saved, error: " + e.getMessage());
        }
        return ResponseEntity.ok("Order saved successfully");
    }



    @PutMapping("update/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable Long orderId, @RequestBody CustomOrder order) {
        CustomOrder toUpdate = orderService.findById(orderId);
        if (toUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        CustomOrder updatedOrder = orderService.updateOrder(orderId, order);
        return ResponseEntity.ok("ordine aggiornato correttamente");
    }

    @GetMapping("getOrders")
    public ResponseEntity<List<CustomOrderDTO>> getOrders(@RequestParam(value = "status", required = false) String status) {
        List<CustomOrderDTO> orders = orderService.getOrders(status);
        return ResponseEntity.ok(orders);
    }
}
