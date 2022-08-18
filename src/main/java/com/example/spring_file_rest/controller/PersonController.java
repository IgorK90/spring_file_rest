package com.example.spring_file_rest.controller;

import com.example.spring_file_rest.entity.Person;
import com.example.spring_file_rest.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;
    public PersonController (PersonService service)
    {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id)
    {
        Optional<Person> personOpt = service.findById(id);

        if (personOpt.isPresent())
            return ResponseEntity.ok(personOpt.get());
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }
}
