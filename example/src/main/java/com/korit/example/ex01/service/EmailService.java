package com.korit.example.ex01.service;


import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendOrderConfirmation() {
        System.out.println("주문이 완료 되었습니다.");
    }
}
