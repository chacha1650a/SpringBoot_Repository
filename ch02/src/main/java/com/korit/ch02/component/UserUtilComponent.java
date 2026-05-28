package com.korit.ch02.component;

import org.springframework.stereotype.Component;

@Component
public class UserUtilComponent {
    public void print() {
        System.out.println("유틸 정보 출력");
    }
}
