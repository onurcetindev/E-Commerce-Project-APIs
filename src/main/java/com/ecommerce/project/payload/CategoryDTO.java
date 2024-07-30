package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//Bu sınıf, kategori verilerini kullanıcıya veya başka bir hizmete taşımak için kullanılabilir.
// Örneğin, bir REST API'de, istemciye kategori bilgilerini JSON formatında döndürmek için bu sınıf kullanılabilir.
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
}
