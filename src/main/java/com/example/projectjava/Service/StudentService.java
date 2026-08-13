package com.example.projectjava.Service;

import com.example.projectjava.DTO.StudentRequest;
import com.example.projectjava.DTO.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    StudentResponse listOne(long id);

    Page<StudentResponse> filter(int page, int size, String name, Sort.Direction direction);


    List<StudentResponse> list();

    StudentResponse create(StudentRequest studentRequest);

    StudentResponse update(StudentRequest studentRequest, long id);

    void delete(long id);
}

