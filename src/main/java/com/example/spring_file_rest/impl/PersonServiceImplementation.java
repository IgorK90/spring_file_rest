package com.example.spring_file_rest.impl;

import com.example.spring_file_rest.entity.Person;
import com.example.spring_file_rest.repository.PersonRepository;
import com.example.spring_file_rest.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImplementation implements PersonService
{
    private final PersonRepository repository;
    public PersonServiceImplementation(PersonRepository repository){this.repository = repository;}
    @Override
    public Optional<Person>findById(Long id)
    {
        return repository.findById(id);
    }
    @Override
    public List<Person> findAll(){return repository.findAll();}
}
