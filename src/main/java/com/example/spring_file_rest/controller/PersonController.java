package com.example.spring_file_rest.controller;

import com.example.spring_file_rest.entity.Person;
import com.example.spring_file_rest.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static java.lang.Long.parseLong;

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

    @GetMapping("/mock")
    public void mockFunc()
    {
        BufferedReader reader;
        List<Person> personList= new LinkedList<Person>();
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Work\\IdeaProjects\\spring_file_rest\\spring_file_rest\\src\\main\\resources\\PersonalData.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                String[] data = line.split("/");
                Person person = new Person( data[0], data[1],parseLong(data[2]));
                personList.add(person);
                line = reader.readLine();
            }
            for (Person p: personList)
                System.out.println(p);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        service.save(personList);
    }
    @GetMapping
    public ResponseEntity<List<Person>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getbyiin/{iin}")
    public ResponseEntity<Person> findOneByIin( @PathVariable Long iin)
    {
        Person optionalPerson  = service.findByIin(iin);
        System.out.println(optionalPerson);

        //return ResponseEntity.ok(service.getByIin(iin));
        return ResponseEntity.ok(optionalPerson);
    }
}
