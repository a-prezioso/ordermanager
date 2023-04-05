package com.milkman.appbackend.repository;

import com.milkman.appbackend.data.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
