package com.sky.people.service;

import com.sky.people.entities.Person;

import java.util.List;

public interface PersonService {

    public abstract Person createPerson(Person p); // Don't need to define public abstract as is by default
    Person getById(int id);
    List<Person> getAll();
    Person update(int id, String name, Integer age, String job);
    Person remove(int id);

}
