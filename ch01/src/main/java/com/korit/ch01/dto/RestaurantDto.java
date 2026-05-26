package com.korit.ch01.dto;

public record RestaurantDto(
        String restaurantName,
        String category,
        String address,
        int rating
) {}
