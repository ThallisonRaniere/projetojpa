package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			createUser("Thallison", "thallison@gmail.com");
			createUser("João da ni Silva", "silva@gmail.com");
			createUser("João", "joao@gmail.com");
			createUser("Maria", "maria@gmail.com");
			createUser("Raniere", "raniere@outlook.com");
		}
		
		List<User> users2 = userRepository.findByParam("ni");
		
		System.out.println(users2);
	}
	
	public void createUser(String name, String email) {
		User user = new User(name, email);
		userRepository.save(user);
	}

}
