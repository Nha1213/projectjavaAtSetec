//package com.example.projectjava.Controller;
//
//import com.example.projectjava.Model.Student;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/student")
//public class StudentController {
//    private final List<Student> list_student =  new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Male", 1L, "Vathana"),
//                    new Student(1, "Male", 2L, "Vathana"),
//                    new Student(1, "Male", 3L, "Vathana")
//            )
//    );
//
//
//   @GetMapping
//
//    public List<Student> getStudents() {
//       return list_student;
//    }
//
//    @GetMapping("/{id}")
//    public Student getStudent(@PathVariable Long id) {
//       return list_student.stream()
//               .filter(student -> student.getId().equals(id))
//               .findFirst()
//               .orElse(null);
//    }
//
//    @PostMapping
//    public Student addStudent(@RequestBody Student student) {
//       list_student.add(student);
//       return list_student.getLast();
//    }
//
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable Long id, @RequestBody Student req) {
//        return list_student.stream()
//                .filter(student -> student.getId().equals(req.getId()))
//                .findFirst()
//                .map(student -> {
//                    student.setName(req.getName());
//                    student.setGender(req.getGender());
//                    student.setAge(req.getAge());
//                    return student;
//                })
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Update false"));
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable Long id) {
//        boolean removed = list_student.removeIf(student -> student.getId().equals(id));
//
//        if (!removed) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
//        }
//    }
//
//}
