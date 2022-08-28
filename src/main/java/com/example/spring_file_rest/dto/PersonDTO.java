package com.example.spring_file_rest.dto;

public class PersonDTO {
    private String name;
    private  long id;
    private long iin;
    //private String surname;

    public PersonDTO() {
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", surname='" + surname + '\'' +
                ", iin=" + iin +
                '}';
    }

    public PersonDTO(String name, String surname, long iin) {
        this.name = name;
        //this.surname = surname;
        this.iin = iin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }

    public long getIin() {
        return iin;
    }

    public void setIin(long iin) {
        this.iin = iin;
    }
}
