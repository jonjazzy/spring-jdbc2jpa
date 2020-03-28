package com.jonjazzy.databasedemo;

import com.jonjazzy.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJPADatabaseDemoApplication implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(SpringJPADatabaseDemoApplication.class);

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJPADatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("User with Id 10001 --> {}", repository.findById(10002));
	}
}
