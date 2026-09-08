package com.example.projectjava.Controller;

import com.example.projectjava.DTO.StudentRequest;
import com.example.projectjava.DTO.StudentResponse;
import com.example.projectjava.Model.Student;
import com.example.projectjava.Service.StudentService;
import com.example.projectjava.common.response.PaginationResponse;
import com.example.projectjava.common.response.SuccessResponse;
import com.example.projectjava.util.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/v-3")
@RequiredArgsConstructor
public class StudentController3 {
    private final StudentService studentService;


//    public StudentController3(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping("/list")
    public ResponseEntity<SuccessResponse<List<StudentResponse>>> list() {

        return ResponseEntity.ok(ApiResponseUtil.success(HttpStatus.OK, studentService.list()));
    }


    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<StudentResponse>> findOne(@PathVariable int id) {
        return ResponseEntity.ok(ApiResponseUtil.success(HttpStatus.OK, studentService.listOne(id)));
    }

    @GetMapping
    public ResponseEntity<PaginationResponse<List<StudentResponse>>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction
    ){
        return ResponseEntity.ok(
                ApiResponseUtil.pagination(HttpStatus.OK, studentService.filter(page, size, name, direction))
        );
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<StudentResponse>> save(@Valid @RequestBody StudentRequest Request) {
        return ResponseEntity.ok(ApiResponseUtil.success(HttpStatus.CREATED, studentService.create(Request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<StudentResponse>> update(@Valid @RequestBody StudentRequest studentRequest, @PathVariable long id) {
        return ResponseEntity.ok(ApiResponseUtil.success(HttpStatus.OK, studentService.update(studentRequest, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<Void>> delete(@PathVariable long id) {
        studentService.delete(id);
        return ResponseEntity.ok(
                ApiResponseUtil.success(HttpStatus.NO_CONTENT)
        );
    }

}
