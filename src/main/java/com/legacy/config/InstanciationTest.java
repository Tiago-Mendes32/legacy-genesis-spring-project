package com.legacy.config;

import org.springframework.boot.CommandLineRunner;

import com.legacy.model.entities.User;


public class InstanciationTest implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Tiago", "Mendes de Góes", "50434220841", "tiagogoes75@gmail.com", "32364893");
		
	}

}
