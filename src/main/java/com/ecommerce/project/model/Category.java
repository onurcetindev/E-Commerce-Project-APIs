package com.ecommerce.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank
    @Size(min = 3, message = "Category name must contain at least 3 character")
    private String categoryName;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product>products;
    //mappedBy = "category": Bu, ilişkiyi ters tarafta (yani Product varlığında) tanımlanan
    // alanın adını belirtir. Product varlığında category adında bir alan vardır ve
    // bu alan Product'ın hangi Category'ye ait olduğunu gösterir.


    //cascade = CascadeType.ALL: Bu, Category varlığı üzerindeki tüm kalıcılık (persistence) işlemlerinin
    // (INSERT, UPDATE, DELETE) ilgili Product varlıklarına da uygulanacağını belirtir.
    // Örneğin, bir Category silindiğinde, bu kategoriye ait tüm Product'lar da silinir.
}
