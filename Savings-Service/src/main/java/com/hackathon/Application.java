package com.hackathon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.hackathon.domain.Account;
import com.hackathon.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account(56784567, "Savings Product1", "NLRABO56784567", 567));
        accounts.add(new Account(56784568, "Savings Product1", "NLRABO56784568", 89));

        accountRepository.save(accounts);
	}

}
