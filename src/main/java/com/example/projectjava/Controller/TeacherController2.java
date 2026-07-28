package com.example.projectjava.Controller;

import com.example.projectjava.DTO.TeacherRequest;
import com.example.projectjava.Model.Teacher;
import com.example.projectjava.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v2/teacher")
public class TeacherController2 {

//    @Autowired
    private final TeacherRepository teacherRepository;
    public TeacherController2(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping()
    public Teacher addTeacher(@RequestBody TeacherRequest req) {
        Teacher teacher = new Teacher();
        teacher.setName(req.getName());
        teacher.setGender(req.getGender());
        teacher.setAge(req.getAge());
        teacher.setClassTeach(req.getClassTeach());
        return teacherRepository.save(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody TeacherRequest req) {
        Teacher isTeacher = teacherRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher Not Found!"));
        isTeacher.setName(req.getName());
        isTeacher.setGender(req.getGender());
        isTeacher.setAge(req.getAge());
        isTeacher.setClassTeach(req.getClassTeach());
        return teacherRepository.save(isTeacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id) {
        Teacher isTeacher = teacherRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher Not Found!"));
        teacherRepository.delete(isTeacher);
    }
}
