package com.example.projectjava.Controller;

import com.example.projectjava.Model.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    private final List<Teacher> list_teacher = new ArrayList<>(
            List.of(
                    new Teacher(1L, "Vathana", "Male", 23L, "4B")
            )
    );

    @GetMapping
    public List<Teacher> getTeacher() {
        return list_teacher;
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        for (Teacher teacher : list_teacher) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!");
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        list_teacher.add(teacher);
        return list_teacher.getLast();
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@RequestBody Teacher req) {
        for (Teacher teacher : list_teacher) {
            if(teacher.getId().equals(req.getId())) {
                teacher.setName(req.getName());
                teacher.setAge(req.getAge());
                teacher.setGender(req.getGender());
                teacher.setClassTeach(req.getClassTeach());
                return list_teacher.getLast();
            }
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!");
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        for (Teacher teacher : list_teacher) {
            if(teacher.getId().equals(id)) {
                list_teacher.remove(teacher);
                return;
            }
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!");
    }
}
