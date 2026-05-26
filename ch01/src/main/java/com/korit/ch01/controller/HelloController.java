package com.korit.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {


    @GetMapping("/api/hello")
    public String hello() {
        return "/hello.html";
    }

    @GetMapping("/api/hello2")
    @ResponseBody
    public String hello2() {
        return "데이터 응답";
    }

    @GetMapping("/api/hello3")
    @ResponseBody
    public Map<String, Object> hello3() {
        return Map.of(
                "name", "김준일",
                "age", 33
        );
    }

    @GetMapping("/api/hello4")
    @ResponseBody
    public List<Object> hello4() {
        return List.of(
                Map.of("김대훈", 20),
                Map.of("김대훈1", 21),
                Map.of("김대훈2", 21)
        );
    }


}