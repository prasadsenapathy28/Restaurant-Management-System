package com.example.review.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review.model.ResOrder;
import com.example.review.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<ResOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public ResOrder addOrder(ResOrder order) {
        return orderRepository.save(order);
    }
    public ResOrder getOrderbyid(int id){
        return orderRepository.findById(id).orElse(null);
    }
    public ResOrder updateOrder(int id, ResOrder order) {
        ResOrder ord = getOrderbyid(id);
        if(ord!=null) {
            ord.setCreatedAt(LocalDateTime.now());
            ord.setItems(order.getItems());
            ord.setUserid(order.getUserid());
            return orderRepository.save(ord);
        }
        return null;
    }

    public String deleteOrder(int id) {
        if(getOrderbyid(id)!=null){
           orderRepository.deleteById(id);
           return "Deleted";
        }
        return "Id not found";
        
    }
}