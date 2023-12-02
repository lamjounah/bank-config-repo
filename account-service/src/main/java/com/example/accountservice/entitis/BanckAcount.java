package com.example.accountservice.entitis;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.modeles.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BanckAcount {
    @Id
    private  String accountID;
    private  double balance;
    private LocalDate creatAt;
    private  String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private  Long customerID;

}
