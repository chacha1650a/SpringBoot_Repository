package com.korit.example.ex01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Product {
    private Long productId;
    private String name;
    private String amount;
    private int price;

    public Long findById() {
        return productId;
    }
}
