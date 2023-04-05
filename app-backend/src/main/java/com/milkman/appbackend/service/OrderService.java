package com.milkman.appbackend.service;

import com.milkman.appbackend.data.dto.CustomOrderDTO;
import com.milkman.appbackend.data.entity.CustomOrder;

import java.util.List;
import java.util.Map;

public interface OrderService {

    void saveOrder(CustomOrder order);

    CustomOrder updateOrder(Long orderId, CustomOrder order);

    CustomOrder findById(Long orderId);

    List<CustomOrderDTO> getOrders(String status);
}
