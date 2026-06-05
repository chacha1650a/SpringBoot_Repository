package com.korit.ch03.service;

import com.korit.ch03.controller.product.dto.ProductReqCreate;
import com.korit.ch03.controller.product.dto.ProductResp;
import com.korit.ch03.entity.Product;
import com.korit.ch03.exception.DuplicatedException;
import com.korit.ch03.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public void create(ProductReqCreate dto) {
        Product foundProduct = productMapper.selectByProductName(dto.getProductName());

        if (foundProduct != null) {
            throw new DuplicatedException("상품명이 이미 존재합니다.", "productName", dto.getProductName());
        }

        Product newProduct = Product.builder()
                .productName(dto.getProductName())
                .price(dto.getPrice())
                .categoryId(dto.getCategoryId())
                .build();

        productMapper.insert(newProduct);
    }

    public List<ProductResp> getAll() {
        List<Product> products = productMapper.selectAll();

        return products.stream()
                .map(product -> ProductResp.builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .categoryId(product.getCategoryId())
                        .createdAt(product.getCreatedAt())
                        .updatedAt(product.getUpdatedAt())
                        .build())
                .toList();
    }

    public ProductResp getOne(Long productId) {
        Product product = productMapper.selectById(productId);
        return ProductResp.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .categoryId(product.getCategoryId())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public ProductResp getOne(String productName) {
        Product product = productMapper.selectByProductName(productName);
        return ProductResp.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .categoryId(product.getCategoryId())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
