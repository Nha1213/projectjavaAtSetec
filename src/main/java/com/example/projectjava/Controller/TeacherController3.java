package com.example.projectjava.Controller;

import com.example.projectjava.DTO.TeacherRequest;
import com.example.projectjava.DTO.TeacherResponse;
import com.example.projectjava.Model.Teacher;
import com.example.projectjava.Repository.TeacherRepository;
import com.example.projectjava.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/v-3")
@RequiredArgsConstructor
public class TeacherController3 {

    private final TeacherService teacherService;
//    public TeacherController3(TeacherService teacherService) {
//        this.teacherService = teacherService;
//    }


    @GetMapping("/list")
    public ResponseEntity<List<TeacherResponse>> list(){
        return ResponseEntity.ok(teacherService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getById(@PathVariable int id){
        return ResponseEntity.ok(teacherService.listOne(id));
    }

    @GetMapping
    public Page<TeacherResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction
    ){
        return teacherService.filter(page, size, name, direction);
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> save(@RequestBody TeacherRequest teacherRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.create(teacherRequest));
    }

    @PutMapping
    public ResponseEntity<TeacherResponse> update(@RequestBody TeacherRequest teacherRequest, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.update(teacherRequest, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        teacherService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
