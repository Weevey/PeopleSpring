package com.sky.people.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Integer id;

    @Size(min=2, max=50)
    @Column(nullable = false) // NOT NULL
    private String name;
    @Min(0)
    @Max(100)
    private int age;
    @NotNull
    private String job;

    private String niNumber;
    public Person(String name, int age, String job, String niNumber) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.niNumber = niNumber;
    }

    // Required - All below \/   \/  \/
    public Person() {
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
