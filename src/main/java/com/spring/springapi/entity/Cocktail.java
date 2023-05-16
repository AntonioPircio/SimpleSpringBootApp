package com.spring.springapi.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
public class Cocktail {
    @Id
    @SequenceGenerator(
            name = "cocktail_sequence",
            sequenceName = "cocktail_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cocktail_sequence"
    )

    private int ID;
    private String name;

    public Cocktail() {}

   public Cocktail(String name) {
       this.name = name;
   }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }
}
