package com.example.projectjava.Controller;

import com.example.projectjava.DTO.StudentRequest;
import com.example.projectjava.DTO.StudentResponse;
import com.example.projectjava.Model.Student;
import com.example.projectjava.Service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/v-3")
public class StudentController3 {
    private final StudentService studentService;


    public StudentController3(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentResponse>> list() {
        return ResponseEntity.ok(studentService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> findOne(@PathVariable int id) {
        return ResponseEntity.ok(studentService.listOne(id));
    }

    @GetMapping
    public Page<StudentResponse> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction
    ){
        return studentService.filter(page, size, name, direction);
    }

    @PostMapping
    public ResponseEntity<StudentResponse> save(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(studentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@RequestBody StudentRequest studentRequest, @PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(studentRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
