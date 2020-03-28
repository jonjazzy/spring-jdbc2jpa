package com.jonjazzy.databasedemo;

import com.jonjazzy.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRESTController
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/allPersons")
    public List<Person> getAllPersons()
    {
        return jdbcTemplate.query("SELECT * FROM Person",
                    new BeanPropertyRowMapper<Person>(Person.class));
    }
}
