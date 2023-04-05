package com.milkman.appbackend.service;

import com.milkman.appbackend.data.dto.CustomOrderDTO;
import com.milkman.appbackend.data.entity.CustomOrder;
import com.milkman.appbackend.data.entity.OrderStatus;
import com.milkman.appbackend.repository.OrderRepository;
import com.milkman.appbackend.util.OrderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Transactional
    @Override
    public void saveOrder(CustomOrder order) {
        order.setOrderStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        orderRepository.save(order);
    }

    @Override
    public CustomOrder updateOrder(Long orderId, CustomOrder order) {
        order.setId(orderId);
        return orderRepository.save(order);
    }

    @Override
    public CustomOrder findById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<CustomOrderDTO> getOrders(String status) {
        List<CustomOrder> orders;
        if (status == null) {
            orders = orderRepository.findAll();
        } else {
            orders = orderRepository.findByOrderStatus(OrderStatus.valueOf(status));
        }
        return OrderConverter.fromEntityToDTO(orders);
    }
}

