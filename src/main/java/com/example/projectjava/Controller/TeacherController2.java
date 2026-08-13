package com.example.projectjava.Controller;

import ch.qos.logback.core.util.StringUtil;
import com.example.projectjava.DTO.TeacherRequest;
import com.example.projectjava.Model.Teacher;
import com.example.projectjava.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
    public Page<Teacher> getTeachers(
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {

        Sort sort =  Sort.by(direction, "id").and(Sort.by(direction, "name"));

        PageRequest pageable = PageRequest.of(page, size, sort);

        if(StringUtils.hasText(name)) {
            return teacherRepository.searchTeacherByNameContainingIgnoreCase(name, pageable);
        }

        return teacherRepository.searchTeacherByNameContainingIgnoreCase(name, pageable);
    }

    @GetMapping("/list")
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
