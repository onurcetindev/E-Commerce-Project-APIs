package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotBlank
    @Size(min = 3, message = "Product name must contain at least 3 characters ")
    private String productName;
    private String image;

    @NotBlank
    @Size(min = 6, message = "Product description must contain at least 6 characters ")
    private String productDescription;
    private Integer quantity;
    private double price; // 100
    private double discount; //25
    private double specialPrice; // 75

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //@JoinColumn(name = "category_id"): Bu, Product tablosunda Category'yi temsil eden yabancı anahtar sütununun
    // adını belirtir. category_id sütunu, Product tablosunda Category tablosundaki ilgili kategoriye işaret eder.

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user;
}
