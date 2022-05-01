package com.example.config;

import com.example.service.Account;
import com.example.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.service"})
public class RootConfig {
    @Bean
    public AccountService accountService(){
        Account account = new Account();
        account.setAccountId("12345");
        account.setAccountHolder("Rashed Alam");
        account.setAccountType("Savings");
        return new AccountService(account);
    }
}
