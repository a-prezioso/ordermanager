package com.milkman.appbackend.data.entity;

import com.milkman.appbackend.repository.DepotRepository;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Plan {

    @Id
    private Long id;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<CustomOrder> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depot_id")
    private Depot depot;

    private PlanStatus planStatus;

    private LocalDateTime startTime;

    private Double totalDistance;

}
