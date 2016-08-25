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
		accounts.add(new Account(123456781, "Payment Product1", "NLRABO123456781", 2500));
        accounts.add(new Account(123456782, "Payment Product1", "NLRABO123456782", 200));

        accountRepository.save(accounts);
	}

}
