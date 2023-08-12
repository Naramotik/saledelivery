package ru.murza.saledelivery.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Manager")
public class Manager {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Not empty!")
    private String name;

    @Column(name = "number")
    @NotNull(message = "Not empty!")
    private String number;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
