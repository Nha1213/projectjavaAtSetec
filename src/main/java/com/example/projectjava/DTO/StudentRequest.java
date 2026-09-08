package com.example.projectjava.DTO;

import com.example.projectjava.Model.Student;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    @NotBlank(message = "Name cannot be null or empty")
    private String name;

    @NotBlank(message = "Gender cannot be null or empty")
    private String gender;

    @NotNull(message = "Age cannot be null")
    @Min(value = 1, message = "Age must be greater than 0")
    private Integer age;

    public Student toEntity() {
        return new Student(
                name,
                gender,
                age
        );
    }
}