package com.example.testdatabase;

public class Student {
    private String Name;
    private String Surname;
    private Integer Marks;

    public Student(String name, String surname, Integer marks) {
        this.Name = name;
        this.Surname = surname;
        this.Marks = marks;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public Integer getMarks() {
        return Marks;
    }

}
