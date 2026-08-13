package com.example.projectjava.DTO;

import com.example.projectjava.Model.Student;

public class TeacherResponse {
    private Long id;
    private String name;
    private String gender;
    private Long age;
    private String classTeach;

    public TeacherResponse(Long id, String name, String gender, Long age, String classTeach) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classTeach = classTeach;
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
