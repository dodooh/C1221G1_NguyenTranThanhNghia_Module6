package com.codegym.service;

import com.codegym.model.Customer;
import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
}
