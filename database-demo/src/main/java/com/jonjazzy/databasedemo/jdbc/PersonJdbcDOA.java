package com.jonjazzy.databasedemo.jdbc;

import com.jonjazzy.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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

    //select * from person WHERE id = {$id}
    public Person findById(int id)
    {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Person WHERE id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class)
        );
    }

    //select * from person WHERE name = {$name}
    public List<Person> findByName(String name)
    {
        return jdbcTemplate.query(
                "SELECT * FROM Person WHERE name=?",
                new Object[]{name},
                new BeanPropertyRowMapper<Person>(Person.class)
        );
    }

    //delete * from person WHERE id = {$id}
    public int deleteById(int id)
    {
        return jdbcTemplate.update(
                "DELETE FROM Person WHERE id=?",
                new Object[] {id}
        );
    }


    //INSERT into table
    public int insertPerson(Person person)
    {
        return jdbcTemplate.update(
                "INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(?, ?, ?, ?);",
                new Object[] {
                        person.getId(),
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())}
        );
    }

    //UPDATE a person
    public int updatePerson(Person person)
    {
        return jdbcTemplate.update(
                "UPDATE PERSON SET name=?, location=?, birth_date=? WHERE id=?;",
                new Object[] {
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()),
                        person.getId()
                }
        );
    }
}
