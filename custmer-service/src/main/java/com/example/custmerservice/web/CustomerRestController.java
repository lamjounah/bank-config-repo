package com.example.custmerservice.web;

import com.example.custmerservice.entits.Customer;
import com.example.custmerservice.repsitory.CustmerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    private CustmerRepository custmerRepository;
    public CustomerRestController(CustmerRepository custmerRepository) {
        this.custmerRepository = custmerRepository;
    }
    @GetMapping("/customers")
    public List<Customer> customerList(){
        return  custmerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public  Customer getById(@PathVariable Long id){
        return  custmerRepository.findById(id).get();
    }



}
