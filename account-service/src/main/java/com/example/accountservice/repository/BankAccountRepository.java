package com.example.accountservice.repository;

import com.example.accountservice.entitis.BanckAcount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BanckAcount,String> {
}
