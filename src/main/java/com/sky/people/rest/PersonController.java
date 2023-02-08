package com.sky.people.rest;

import com.sky.people.entities.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private List<Person> people = new ArrayList<>();

        @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
            return "Hello, World!";
        }

    @RequestMapping(value = "/Steve", method = RequestMethod.GET)
    public Person second() {
            for (Person i : people) {
                return i;
        }
//        return "<h1>Steve!~!!!!!!!</h1>";
        return null;
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody Person person) { // pulls person from the body
            this.people.add(person); // Add a new person to the list
            return this.people.get(this.people.size() -1); // Return the last person in the list
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {
            return this.people;
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable int id) { // Pulls id from the path
          return this.people.get(id);
    }
}
