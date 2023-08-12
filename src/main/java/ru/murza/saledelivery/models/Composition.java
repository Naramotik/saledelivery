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
@Table(name = "Composition")
public class Composition {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count")
    @NotNull(message = "Not empty!")
    private Double count;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @OneToMany(mappedBy = "composition")
    private List<Ingredient> ingredients;
}
