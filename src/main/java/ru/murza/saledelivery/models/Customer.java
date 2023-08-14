package ru.murza.saledelivery.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

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

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
