package com.greenfox.finder;

import com.greenfox.finder.model.User;
import com.greenfox.finder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinderApplication.class, args);
	}

}
