package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.TourType;
import com.codegym.service.ICustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = this.customerService.findAll();
        return ResponseEntity.ok(customers);
    }
}
