package com.milkman.appbackend.repository;

import com.milkman.appbackend.data.entity.CustomOrder;
import com.milkman.appbackend.data.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<CustomOrder, Long> {
    List<CustomOrder> findByOrderStatus(OrderStatus status);
}
