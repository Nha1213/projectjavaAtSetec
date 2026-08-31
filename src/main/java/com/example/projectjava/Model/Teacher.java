package com.example.projectjava.Model;

import com.example.projectjava.DTO.TeacherResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private Long age;
    private String classTeach;

    public Teacher() {
    }

    public Teacher(Long id, String name, String gender, Long age, String classTeach) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classTeach = classTeach;
    }

    public Teacher(String name, String gender, Long age, String classTeach) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classTeach = classTeach;
    }

    public TeacherResponse toResponse() {
        return new TeacherResponse(
                id,
                name,
                gender,
                age,
                classTeach
        );
    }

    public Long getId() {
        return id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getClassTeach() {
        return classTeach;
    }

    public void setClassTeach(String classTeach) {
        this.classTeach = classTeach;
    }
}