package com.legacy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.legacy.model.entities.User;
import com.legacy.model.repositories.UserRepository;

@Configuration
public class InstanciationTest implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();

		User user1 = new User(null, "Tiago", "Mendes de Góes", "50434220841", "tiagogoes75@gmail.com", "32364893");
		userRepository.save(user1);
	}
}
