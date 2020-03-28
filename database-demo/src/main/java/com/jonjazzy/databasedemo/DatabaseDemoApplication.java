package com.jonjazzy.databasedemo;

import com.jonjazzy.databasedemo.jdbc.PersonJdbcDOA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(DatabaseDemoApplication.class);
	@Autowired
	PersonJdbcDOA dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All Users --> {}", dao.findAll());
	}
}
