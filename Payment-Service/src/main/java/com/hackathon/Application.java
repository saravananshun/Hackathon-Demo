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
		accounts.add(new Account(123456781, "Payment Product1", "N.Q.PASTIN", "EUR" , "NL88 RABO 0191 7032 57", 2500));
        accounts.add(new Account(123456782, "Payment Product1", "B. Nyalan", "EUR" , "NL88 RABO 0191 7032 60 ", 200));
		accounts.add(new Account(123456782, "Payment Product1", "James Wyan", "EUR" , "NL88 RABO 0191 7032 70 ", 100));
		accounts.add(new Account(123456782, "Payment Product1", "Jeron Wolf", "EUR" , "NL88 RABO 0191 7032 80 ", 300));

        accountRepository.save(accounts);
	}

}
