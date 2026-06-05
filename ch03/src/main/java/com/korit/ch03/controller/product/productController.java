package com.korit.ch03.controller.product;

import com.korit.ch03.controller.dto.ApiResponse;
import com.korit.ch03.controller.product.dto.ProductReqCreate;
import com.korit.ch03.controller.product.dto.ProductResp;
import com.korit.ch03.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class productController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody ProductReqCreate dto) {
        productService.create(dto);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResp>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok(productService.getAll()));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse> getOne(@PathVariable Long productId) {
        return ResponseEntity.ok(ApiResponse.ok(productService.getOne(productId)));
    }

    @GetMapping("/productName/{productName}")
    public ResponseEntity<ApiResponse> getOne(@PathVariable String productName) {
        return ResponseEntity.ok(ApiResponse.ok(productService.getOne(productName)));
    }
}
