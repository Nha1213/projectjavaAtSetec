//package com.example.projectjava.Service;
//
//import com.example.projectjava.Model.Student;
//import com.example.projectjava.Repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StudentService {
//    @Autowired
//    private final StudentRepository studentRepository;
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    public List<Student> getList(){
//        return studentRepository.findAll();
//    }
//}
