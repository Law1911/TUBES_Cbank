package com.cbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cbank.Model.Account;
import com.cbank.Model.User;
import com.cbank.Repository.AccountRepository;
import com.cbank.Repository.UserRepository;

@SpringBootApplication
public class CbankApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(CbankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createInitialData();
	}

	private void createInitialData() {
		if (!userRepository.existsByUsername("novita")) {
			User user1 = new User("novita", "novita");
			Account account1 = new Account(100000, "novita", "sabila");
			user1.setAccount(account1);
			userRepository.save(user1);
			accountRepository.save(account1);
		}

		if (!userRepository.existsByUsername("jeje")) {
			User user1 = new User("jeje", "jeje");
			Account account1 = new Account(100000, "jeje", "jeje");
			user1.setAccount(account1);
			userRepository.save(user1);
			accountRepository.save(account1);
		}
	}

}
