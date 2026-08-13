package com.example.projectjava.Service.Implement;

import com.example.projectjava.DTO.StudentRequest;
import com.example.projectjava.DTO.StudentResponse;
import com.example.projectjava.Model.Student;
import com.example.projectjava.Repository.StudentRepository;
import com.example.projectjava.Service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;


    public  StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentResponse> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return studentRepository.findAll(sort).stream().map(Student::toResponse).toList();
    }

    @Override
    public StudentResponse create(StudentRequest request) {
        return studentRepository.save(request.toEntity()).toResponse();
    }

    @Override
    public StudentResponse update(StudentRequest studentRequest, long id) {
        Student stuUp = studentRepository.findById((int) id).orElseThrow(()  -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        stuUp.setName(studentRequest.getName());
        stuUp.setAge(studentRequest.getAge());
        stuUp.setGender(studentRequest.getGender());
        return studentRepository.save(stuUp).toResponse();
    }

    @Override
    public void delete(long id) {
        Student stu = studentRepository.findById((int) id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Student not found"
                        )
                );

        studentRepository.delete(stu);
    }

    @Override
    public StudentResponse listOne(long id) {
        return studentRepository.findById((int) id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found!")).toResponse();
    }

    @Override
    public Page<StudentResponse> filter(int page, int size, String name, Sort.Direction direction) {
        Sort sort = Sort.by(direction, "id")
                .and(Sort.by(direction, "name"));

        PageRequest pageable = PageRequest.of(page - 1, size, sort);

        if (StringUtils.hasText(name)) {
            return studentRepository.searchStudentByNameContainingIgnoreCase(name, pageable).map(Student::toResponse);
        }

//        return studentRepository.findAll(pageable);
        return studentRepository.searchStudentByNameContainingIgnoreCase(name, pageable).map(Student::toResponse);
    }
}
