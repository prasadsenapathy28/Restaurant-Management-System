package com.example.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.review.model.ResOrder;
import com.example.review.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("getorder")
    public List<ResOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("addOrder")
    public ResOrder addOrder(@RequestBody ResOrder order) {
        return orderService.addOrder(order);
    }

    @PutMapping("update/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody ResOrder order) {
        if(orderService.updateOrder(id, order)!=null)
            return "Updated";
        return "Id not found";
    }

    @DeleteMapping("delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        return orderService.deleteOrder(id);
    }
}
