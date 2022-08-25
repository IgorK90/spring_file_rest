package com.example.spring_file_rest;

import com.example.spring_file_rest.dto.PersonDTO;
import com.example.spring_file_rest.entity.Person;
import org.modelmapper.ModelMapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Long.parseLong;

public class Test1 {

    public Test1() throws IOException {
    }

    public static void main(String[] args)
    {
        ModelMapper modelMapper = new ModelMapper();
        Person person = new Person("Alex","Smirnov",1234);
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);

        assert (person.getName() == personDTO.getName());



    }
}
