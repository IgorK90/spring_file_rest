package com.example.spring_file_rest;

import com.example.spring_file_rest.entity.Person;
import org.springframework.boot.SpringApplication;

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

    public static void main(String[] args) {
        SpringApplication.run(Test1.class, args);
    }
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


    }
}
