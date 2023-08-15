package ru.murza.saledelivery.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Ingredient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",
            nullable = false)
    @NotNull(message = "Not empty!")
    private String title;

    @ManyToOne
    @JoinColumn(name = "composition_id")
    private Composition composition;

    @OneToOne(fetch = FetchType.EAGER)
    private Measure measure;
}
