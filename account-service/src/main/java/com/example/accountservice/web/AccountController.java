package com.example.accountservice.web;

import com.example.accountservice.client.CustomerRestClient;
import com.example.accountservice.entitis.BanckAcount;
import com.example.accountservice.modeles.Customer;
import com.example.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public AccountController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BanckAcount> accountList(){
        List<BanckAcount> accountlist = bankAccountRepository.findAll();
        accountlist.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerID()));
        });
        return accountlist;
    }
    @GetMapping("/accounts/{id}")
    public BanckAcount  bankAcountByid(@PathVariable String id){
        BanckAcount banckAcount=bankAccountRepository.findById(id).get();
        Customer customer =customerRestClient.findCustomerById(banckAcount.getCustomerID());
        banckAcount.setCustomer(customer);

        return banckAcount;
    }

}
