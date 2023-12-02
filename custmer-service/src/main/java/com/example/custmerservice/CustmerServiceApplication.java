package com.example.custmerservice;

import com.example.custmerservice.config.GlobalConfig;
import com.example.custmerservice.entits.Customer;
import com.example.custmerservice.repsitory.CustmerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustmerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustmerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustmerRepository custmerRepository){
		 return args -> {
			 List<Customer> customerList=List.of(
			 Customer.builder()
					 .firstName("hamza")
					 .lastNmae("lamjounah")
					 .email("hamza@gmail.com").build(),

			 Customer.builder()
					 .firstName("hamz")
					 .lastNmae("lamjounh")
					 .email("hmza@gmail.com").build()
			 );
			 custmerRepository.saveAll(customerList);

		 };
	}
}
