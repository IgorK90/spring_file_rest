package com.example.spring_file_rest.service;

import com.example.spring_file_rest.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {

    Optional<Person> findById(Long id);
    List<Person> findAll();

}
