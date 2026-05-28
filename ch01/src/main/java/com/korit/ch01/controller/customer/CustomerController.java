package com.korit.ch01.controller.customer;

import com.korit.ch01.controller.customer.dto.CustomerReqCreate;
import com.korit.ch01.controller.customer.dto.CustomerReqList;
import com.korit.ch01.controller.customer.dto.CustomerReqUpdate;
import com.korit.ch01.controller.customer.dto.CustomerResp;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer", description = "고객 정보 등록 / 조회 / 수정 / 삭제")
public class CustomerController {

//    @PostMapping
//    public ResponseEntity<CustomerResp> create(@RequestBody CustomerReqCreate dto) {
//
//        return ResponseEntity.ok(new CustomerResp(10, 1, "customer1234", "+8201011112222", LocalDateTime.now(), LocalDateTime.now()));
//    }

    @PostMapping
    public ResponseEntity<CustomerResp> create(@RequestBody CustomerReqCreate dto) {

        return ResponseEntity.ok(new CustomerResp(1, 1, "test1234", "+8201011112222", LocalDateTime.now(), LocalDateTime.now()));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<CustomerResp>> list(CustomerReqList dto) {
        System.out.println(dto.getQuery());
        System.out.println(dto.getName());
        System.out.println(dto.getEmail());
        return ResponseEntity.ok(List.of());
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResp> update(@RequestBody CustomerReqUpdate dto){
        System.out.println(dto);
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<CustomerResp> modify(@RequestBody CustomerReqUpdate dto) {
        System.out.println(dto);
        return ResponseEntity.ok(null);
    }
}
