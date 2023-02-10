package com.sky.people.service;

import com.sky.people.entities.Person;
import com.sky.people.exceptions.PersonNotFoundException;
import com.sky.people.persistence.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceDB implements PersonService {

    private PersonRepo repo;

    public PersonServiceDB(PersonRepo repo) {
        this.repo = repo;
    }

    @Override
    public Person createPerson(Person p) {
        return this.repo.save(p);
    }

    @Override
    public Person getById(int id) {
        return this.repo.findById(id).orElseThrow(() -> new PersonNotFoundException());
    }

    @Override
    public List<Person> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Person update(int id, String name, Integer age, String job) {
        Person old = this.getById(id);
        if (name != null) old.setName(name);
        if (age != null) old.setAge(age);
        if (job != null) old.setJob(job);

        return old;

    }

    @Override
    public Person remove(int id) {
        Person existing = this.getById(id);
        this.repo.deleteById(id);
        return existing;
    }
}
