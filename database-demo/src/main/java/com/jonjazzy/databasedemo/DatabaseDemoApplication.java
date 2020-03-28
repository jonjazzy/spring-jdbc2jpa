package com.jonjazzy.databasedemo;

import com.jonjazzy.databasedemo.entity.Person;
import com.jonjazzy.databasedemo.jdbc.PersonJdbcDOA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
//		LOGGER.info("User Id 10001 --> {}", dao.findById(10001));
//		LOGGER.info("User with Name = James --> {}", dao.findByName("James"));
//		LOGGER.info("Delete Person with Id 10001 --> ", dao.deleteById(10001));

		LOGGER.info("Insert the Person 10020 --> {}",
				dao.insertPerson(new Person(10020, "Jannette", "Tokyo", new Date()))
		);

		LOGGER.info("Update the Person 10003 --> {}",
				dao.updatePerson(new Person(10003, "Pieter", "Eintracht", new Date()))
		);
	}
}
