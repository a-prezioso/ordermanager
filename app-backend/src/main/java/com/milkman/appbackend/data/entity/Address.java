package com.milkman.appbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float coordinateX;

    private Float coordinateY;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Depot> depots;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Package> packages;

}
