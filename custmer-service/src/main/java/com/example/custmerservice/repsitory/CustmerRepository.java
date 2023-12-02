package com.example.custmerservice.repsitory;

import com.example.custmerservice.entits.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustmerRepository extends JpaRepository<Customer,Long> {

}
