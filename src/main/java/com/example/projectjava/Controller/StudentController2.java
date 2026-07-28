package com.example.projectjava.Controller;

import com.example.projectjava.DTO.StudentRequest;
import com.example.projectjava.Model.Student;
import com.example.projectjava.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v2/student")
public class StudentController2 {

//    @Autowired
    private final StudentRepository studentRepository;
    public StudentController2(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student findOne(@PathVariable int id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found!"));
    }

    @PostMapping
    public Student save(@RequestBody StudentRequest student) {
        Student studentAdd = new Student();
        studentAdd.setName(student.getName());
        studentAdd.setAge(student.getAge());
        studentAdd.setGender(student.getGender());
        return studentRepository.save(studentAdd);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody StudentRequest student) {
        Student idCheck = studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found!"));
        idCheck.setName(student.getName());
        idCheck.setAge(student.getAge());
        idCheck.setGender(student.getGender());
        return studentRepository.save(idCheck);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        Student isCheck = studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found!"));
        studentRepository.delete(isCheck);
    }

}
