package com.milkman.appbackend.repository;

import com.milkman.appbackend.data.entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepotRepository extends JpaRepository<Depot, Long> {
}
