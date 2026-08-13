package com.example.projectjava.DTO;

import com.example.projectjava.Model.Teacher;

public class TeacherRequest {
    private String name;
    private String gender;
    private Long age;
    private String classTeach;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher toEntity() {
        return  new Teacher(name, gender, age, classTeach);
    }
}
