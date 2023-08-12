package ru.murza.saledelivery.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Dish")
public class Dish {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost")
    @NotNull(message = "Not empty!")
    private Double cost;

    @OneToMany(mappedBy = "dish")
    private List<Composition> compositions;

    @ManyToMany(mappedBy = "dishes")
    private List<Store> stores;

    @ManyToMany(mappedBy = "dishes")
    private List<Order> orders;
}
