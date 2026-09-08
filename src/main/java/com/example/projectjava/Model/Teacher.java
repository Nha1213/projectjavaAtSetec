package com.example.projectjava.Model;

import com.example.projectjava.DTO.TeacherResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teacher")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private Long age;
    private String classTeach;




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

}