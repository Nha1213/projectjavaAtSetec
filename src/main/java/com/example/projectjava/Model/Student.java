package com.example.projectjava.Model;


import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import com.example.projectjava.DTO.StudentResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private int age;


    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Student(int age, String gender, Long id, String name) {
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.name = name;
    }


    public Student toEntity(){
        return new Student(age, gender, id, name);
    }

    public StudentResponse toResponse(){
        return new StudentResponse(id, name, gender, age);
    }
}
