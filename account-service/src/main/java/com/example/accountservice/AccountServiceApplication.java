package com.example.accountservice;

import com.example.accountservice.client.CustomerRestClient;
import com.example.accountservice.entitis.BanckAcount;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

 @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.allCustomers().forEach(c->{
                BanckAcount banckAcount = BanckAcount.builder()
                        .accountID(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*80000)
                        .creatAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerID(c.getId()).build();
                BanckAcount banckAcount1 = BanckAcount.builder()
                        .accountID(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*90000)
                        .creatAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerID(c.getId()).build();
                accountRepository.save(banckAcount1);
                accountRepository.save(banckAcount);
            });




        };
    }

}
