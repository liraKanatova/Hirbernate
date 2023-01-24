package org.example.model;

import jakarta.persistence.*;
import jakarta.persistence.metamodel.StaticMetamodel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.dao.LaptopDao;
import org.example.enums.OpertionSystem;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "laptops")

public class Laptop {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Laptop_id_generator"
    )
    @SequenceGenerator(name = "Laptop_id_generator",
    sequenceName = "programmer_seq",
    allocationSize = 1)
   private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_system")
    private OpertionSystem opertionSystem;
   private String brand;
   private int memory;
   private double price;
   private LocalDate dateOfIssue;

    public Laptop(OpertionSystem opertionSystem, String brand, int memory, double price, LocalDate dateOfIssue) {
        this.opertionSystem = opertionSystem;
        this.brand = brand;
        this.memory = memory;
        this.price = price;
        this.dateOfIssue = dateOfIssue;
    }

    public Laptop() {

    }



}





