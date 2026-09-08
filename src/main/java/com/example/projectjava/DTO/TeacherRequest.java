package com.example.projectjava.DTO;

import com.example.projectjava.Model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {
    private String name;
    private String gender;
    private Long age;
    private String classTeach;


    public Teacher toEntity() {
        return  new Teacher(name, gender, age, classTeach);
    }
}
