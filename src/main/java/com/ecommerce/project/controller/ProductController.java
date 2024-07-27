package com.ecommerce.project.controller;


import com.ecommerce.project.model.Category;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    //@RequestBody:
    //Bu anotasyon, HTTP isteğinin gövdesinde gönderilen JSON verisini alır ve belirtilen
    // Java nesnesine (bu durumda Product nesnesi) dönüştürür.

    //{categoryId} kısmı dinamik bir URL parçasıdır ve metodun parametreleri arasında @PathVariable ile alınır.

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product,
                                                 @PathVariable Long categoryId)
    {


        ProductDTO productDTO = productService.addProduct(categoryId,product);
        return new ResponseEntity<>(productDTO,HttpStatus.CREATED);
    }
}
