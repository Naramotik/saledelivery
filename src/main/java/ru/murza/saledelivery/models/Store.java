package ru.murza.saledelivery.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Store")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    @NotNull(message = "Not empty!")
    private String address;

    @OneToMany(mappedBy = "store")
    private List<Manager> managers;

    @OneToMany(mappedBy = "store")
    private List<Order> orders;

    @ManyToMany
    @JoinTable(
            name = "store_dish",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;
}
