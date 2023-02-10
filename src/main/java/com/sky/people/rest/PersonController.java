package com.sky.people.rest;

import com.sky.people.dto.PersonDTO;
import com.sky.people.dto.PersonReqDTO;
import com.sky.people.entities.Person;
import com.sky.people.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

//    private List<Person> people = new ArrayList<>();
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String greeting() {
            return "Hello, World!";
        }
        private PersonService service; // this service variable is a dependency
        public PersonController(PersonService service) {
            this.service = service;
        }

        // ALL BELOW HAS MOVED OVER TO PERSONSERVICELIST CLASS

//    @RequestMapping(value = "/testpage", method = RequestMethod.GET)
//    public void welcome() {
//        return testpage.html;
//    }

//    @RequestMapping(value = "/Steve", method = RequestMethod.GET)
////    public Person second() {
////            for (Person i : people) {
////                return i;
////        }
////        return "<h1>Steve!~!!!!!!!</h1>";
//        return null;
//    }

    @PostMapping("/create")
    public PersonDTO addPerson(@RequestBody PersonReqDTO person) { // pulls person from the body
        Person toCreate = new Person(person.getFullName(), person.getOldNess(), person.getOccupation(), person.getNotNiNumber());
        Person created = this.service.createPerson(toCreate);

        PersonDTO dto = new PersonDTO(created.getName(), created.getAge(), created.getJob());
        return dto;
        //return this.service.createPerson(person);
//            this.people.add(person); // Add a new person to the list
//            return this.people.get(this.people.size() -1); // Return the last person in the list
    }
//
    @GetMapping("/getAll")
    public List<PersonDTO> getAll() {
            List<Person> found = this.service.getAll();
            List<PersonDTO> dtos = new ArrayList<>();
            for (Person person : found) {
                PersonDTO dto = new PersonDTO(person.getName(), person.getAge(), person.getJob());
                dtos.add(dto);
            }
            return dtos;
    }
//
    @GetMapping("/get/{id}")
    public PersonDTO getPerson(@PathVariable int id) { // Pulls id from the path
          Person found = this.service.getById(id);
          PersonDTO dto = new PersonDTO(found.getName(), found.getAge(), found.getJob());
          return dto;
    }
//
    @PatchMapping("/update/{id}")
    public PersonDTO updatePerson(@PathVariable int id, @Valid @PathParam("name") String name, @PathParam("age") Integer age, @PathParam("job") String job) {
        Person updated = this.service.update(id, name, age, job);
        PersonDTO dto = new PersonDTO(updated.getName(), updated.getAge(), updated.getJob());
        return dto;
        }
//            Person old = this.people.get(id);
//            if (name != null) old.setName(name);
//            if (age != null) old.setAge(age);
//            if (job != null) old.setJob(job);
//
//            return old;

//
    @DeleteMapping("/remove/{id}")
    public PersonDTO removePerson(@PathVariable int id) {
            Person removed = this.service.remove(id);
            PersonDTO dto = new PersonDTO(removed.getName(), removed.getAge(), removed.getJob());
            return dto;
    }

}
