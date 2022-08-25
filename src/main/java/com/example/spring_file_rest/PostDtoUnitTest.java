package com.example.spring_file_rest;

import com.example.spring_file_rest.dto.PersonDTO;
import com.example.spring_file_rest.entity.Person;
import org.modelmapper.ModelMapper;


public class PostDtoUnitTest {
    public void test1(String[] args) {


        ModelMapper modelMapper = new ModelMapper();
        Person person = new Person();
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);

        assert (person.getName() == personDTO.getName());
    }
}
