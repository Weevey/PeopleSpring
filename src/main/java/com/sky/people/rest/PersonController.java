package com.sky.people.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

        @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
            return "Hello, World!";
        }

    @RequestMapping(value = "/Steve", method = RequestMethod.GET)
    public String second() {
        return "Steve!~!!!!!!!";
    }
}
