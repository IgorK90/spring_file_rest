package com.example.spring_file_rest;

import com.example.spring_file_rest.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Long.parseLong;

@SpringBootApplication
public class SpringFileRestApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringFileRestApplication.class, args);
    }

}
