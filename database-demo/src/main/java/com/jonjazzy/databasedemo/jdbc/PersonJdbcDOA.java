package com.jonjazzy.databasedemo.jdbc;

import com.jonjazzy.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDOA
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person
    public List<Person> findAll()
    {
        return jdbcTemplate.query("SELECT * FROM Person",
                        new BeanPropertyRowMapper<Person>(Person.class));
    }
}
