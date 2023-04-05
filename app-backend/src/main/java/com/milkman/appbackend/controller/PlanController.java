package com.milkman.appbackend.controller;

import com.milkman.appbackend.data.entity.Plan;
import com.milkman.appbackend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plans")
@CrossOrigin
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping("/start")
    public ResponseEntity<?> startPlan(@RequestParam("depotId") Long depotId) {
        try {
            Plan plan = planService.startPlan(depotId);
            if (plan == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Depot not found");
            }
            return ResponseEntity.ok(plan);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error starting the plan: " + e.getMessage());
        }
    }
}
