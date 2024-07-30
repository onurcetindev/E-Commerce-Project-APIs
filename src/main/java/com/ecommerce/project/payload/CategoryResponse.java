package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    //CategoryResponse sınıfı, sayfalama (pagination) bilgileri ile birlikte kategori verilerini taşımak için kullanılır.
    // Bu sınıf, bir sayfalama yanıtında döndürülen kategori verilerini ve ilgili sayfalama meta verilerini içerir.

    private List<CategoryDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;

}
