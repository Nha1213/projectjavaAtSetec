package com.example.projectjava.DTO;

import com.example.projectjava.Model.Student;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentRequest {
    private String name;
    private String gender;
    private int age;

    public Student toEntity(){
        return new Student(name,gender,age);
    }

}
