package com.example.accountservice.modeles;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
public class Customer {
    private  Long id;
    private  String firstName ,lastName,email;
}
