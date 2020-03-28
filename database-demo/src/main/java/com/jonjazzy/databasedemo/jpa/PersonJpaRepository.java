package com.jonjazzy.databasedemo.jpa;

import com.jonjazzy.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository     //Repository
@Transactional  //Transaction
public class PersonJpaRepository
{
    /*
        Connect to Database
        All d operations performed in a specific session are stored inside @PersistenceContext.
        EntityManager is the Interface to the @PersistenceContext
    */
    @PersistenceContext
    EntityManager entityManager;

    //select * from person WHERE id = {$id}
    public Person findById(int id)
    {
        return entityManager.find(Person.class, id);
    }
}
