package com.example.projectjava.Model;


import com.example.projectjava.DTO.StudentResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private int age;


    public Student(int age, String gender, Long id, String name) {
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.name = name;
    }

    public Student() {}

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student toEntity(){
        return new Student(age, gender, id, name);
    }

    public StudentResponse toResponse(){
        return new StudentResponse(id, name, gender, age);
    }
}
