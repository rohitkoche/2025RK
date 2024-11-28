package com.crm2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;

//    @ManyToMany
//   @JoinTable(name = "stop_bus",
//           joinColumns = @JoinColumn(name = "stop_id"),
//           inverseJoinColumns = @JoinColumn(name = "bus_id"))
//    private Set<Bus> buses = new LinkedHashSet<>();
}