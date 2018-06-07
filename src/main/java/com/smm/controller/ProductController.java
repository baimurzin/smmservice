package com.smm.controller;

import com.smm.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("dev/products/pull")
    public ResponseEntity pullProducts(){
        productService.updateProducts();
        return ResponseEntity.ok().build();
    }
}
