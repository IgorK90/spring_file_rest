package com.example.spring_file_rest.controller;

import com.example.spring_file_rest.dto.PersonDTO;
import com.example.spring_file_rest.entity.Person;
import com.example.spring_file_rest.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
        return ResponseEntity.notFound().build();
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
                String name = data[0];
                String surname = data[1];
                Long iin = null;
                try
                {
                    iin = parseLong(data[2]);
                    Person person = new Person(name, surname, iin);
                    personList.add(person);
                }
                catch (Exception e)
                {
                    System.out.println("iin is not parseable");
                }

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
    public ResponseEntity<Page<Person>> findAll(@RequestParam("page") int page,
                                                @RequestParam("size") int size,
                                                Pageable pageable)
    {
        return ResponseEntity.ok(service.findAll( page,  size, pageable));
    }

    @GetMapping("/getbyiin/{iin}")
    public ResponseEntity<PersonDTO> findOneByIin( @PathVariable Long iin)
    {
        Person optionalPerson  = service.findByIin(iin);
        ModelMapper modelMapper = new ModelMapper();
        PersonDTO personDTO = modelMapper.map(optionalPerson, PersonDTO.class);
        System.out.println(personDTO);

        //return ResponseEntity.ok(service.getByIin(iin));
        return ResponseEntity.ok(personDTO);
    }
}
