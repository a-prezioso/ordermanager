package com.milkman.appbackend.util;

import com.milkman.appbackend.data.dto.CustomOrderDTO;
import com.milkman.appbackend.data.entity.CustomOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {

    public static List<CustomOrderDTO> fromEntityToDTO(List<CustomOrder> orders) {
        List<CustomOrderDTO> dtos = new ArrayList<>();
        for (CustomOrder order : orders) {
            CustomOrderDTO dto = new CustomOrderDTO();
            dto.setOrderName(order.getOrderName());
            dto.setOrderStatus(order.getOrderStatus().toString());
            dto.setOrderNumber(order.getOrderNumber().toString());
            dto.setSupplierName(order.getSupplier().getName());
            dtos.add(dto);
        }
        return dtos;
    }

}
