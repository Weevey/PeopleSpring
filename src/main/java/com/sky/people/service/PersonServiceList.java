package com.sky.people.service;

import com.sky.people.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Service
public class PersonServiceList implements PersonService{
    private List<Person> people = new ArrayList<>();
    @Override
    public Person createPerson(Person person) {
        this.people.add(person); // Add a new person to the list
        return this.people.get(this.people.size() -1); // Return the last person in the list
    }

    @Override
    public Person getById(int id) {
        return this.people.get(id);
    }

    @Override
    public List<Person> getAll() {
        return this.people;
    }

    @Override
    public Person update(int id, String name, Integer age, String job) {
        Person old = this.people.get(id);
        if (name != null) old.setName(name);
        if (age != null) old.setAge(age);
        if (job != null) old.setJob(job);

        return old;
    }

    @Override
    public Person remove(int id) {
        return this.people.remove(id);
    }
}
