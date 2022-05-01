package com.example.config;

import com.example.service.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.service"})
public class RootConfig {
    @Bean
    public Account account(){
        Account account = new Account();
        account.setAccountId("12345");
        account.setAccountHolder("Rashed Alam");
        account.setAccountType("Savings");
        return account;
    }
}
