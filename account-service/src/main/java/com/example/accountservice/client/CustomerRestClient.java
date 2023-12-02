package com.example.accountservice.client;

import com.example.accountservice.modeles.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTMER-SERVICE")
public interface CustomerRestClient {

@GetMapping("/customers/{id}")
@CircuitBreaker(name = "customerservice", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
@GetMapping("/customers")
@CircuitBreaker(name = "customerservice", fallbackMethod = "getAllCustomers")
  List<Customer>  allCustomers();


  default Customer getDefaultCustomer(Long id ,Exception exception){
       Customer customer = new Customer();
       customer.setId(id);
       customer.setFirstName("not va");
       customer.setLastName("not va");
       customer.setEmail("not");
       return  customer;
  }
  default List<Customer> getAllCustomers(Exception exception){
      return List.of();
  }


}
