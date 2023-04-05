package com.milkman.appbackend.service;

import com.milkman.appbackend.data.entity.*;
import com.milkman.appbackend.data.entity.Package;
import com.milkman.appbackend.repository.DepotRepository;
import com.milkman.appbackend.repository.OrderRepository;
import com.milkman.appbackend.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private DepotRepository depotRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PlanRepository planRepository;


    @Override
    public Plan startPlan(Long depotId) {
        Depot depot = depotRepository.findById(depotId).orElse(null);
        if (depot == null) {
            return null;
        }

        List<CustomOrder> orders = orderRepository.findByOrderStatus(OrderStatus.PENDING);

        Plan plan = new Plan();
        plan.setDepot(depot);
        plan.setOrders(orders);

        calculateFakePath(plan);


        return plan;
    }

    private void calculateFakePath(Plan plan) {
        double totalDistance = 0;
        Address previousAddress = plan.getDepot().getAddress();

        for (CustomOrder order : plan.getOrders()) {
            for (Package pkg : order.getPackages()) {
                Address currentAddress = pkg.getAddress();
                double distance = Math.sqrt(Math.pow(currentAddress.getCoordinateX() - previousAddress.getCoordinateX(), 2)
                        + Math.pow(currentAddress.getCoordinateY() - previousAddress.getCoordinateY(), 2));
                totalDistance += distance;
                previousAddress = currentAddress;
            }
        }

        // Calcola la distanza tra l'ultimo punto e il depot
        Address depotAddress = plan.getDepot().getAddress();
        double distance = Math.sqrt(Math.pow(depotAddress.getCoordinateX() - previousAddress.getCoordinateX(), 2)
                + Math.pow(depotAddress.getCoordinateY() - previousAddress.getCoordinateY(), 2));
        totalDistance += distance;

        // Imposta la distanza totale nel piano
        plan.setTotalDistance(totalDistance);

        // Imposta lo stato del piano su COMPLETED
        plan.setPlanStatus(PlanStatus.SUCCEDED);
        planRepository.save(plan);
        elaborateOrders(plan);
    }

    private void elaborateOrders(Plan plan) {
        plan.getOrders().stream().forEach(order -> {
            order.setOrderStatus(OrderStatus.COMPLETED);
            orderRepository.save(order);
        });
    }
}

