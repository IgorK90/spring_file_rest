package com.example.spring_file_rest.service;

import com.example.spring_file_rest.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {

    Optional<Person> findById(Long id);

    Page<Person> findAll(int page, int size, Pageable pageable);


    void mockFunc();

    void save(List<Person> personList);

    Person findByIin(Long iin);
}
