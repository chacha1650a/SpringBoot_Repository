package com.korit.example.ex01.service;

import com.korit.example.ex01.dto.Member;
import com.korit.example.ex01.dto.Product;
import com.korit.example.ex01.repository.MemberRepository;
import com.korit.example.ex01.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final EmailService emailService;

    public void order(Long memberId, Long productId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원 없음"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품 없음"));
        emailService.sendOrderConfirmation(member.getEmail(), product.getName());
    }
}
