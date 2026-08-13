package com.example.projectjava.Service;

import com.example.projectjava.DTO.TeacherRequest;
import com.example.projectjava.DTO.TeacherResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TeacherService {
    List<TeacherResponse> list();

    TeacherResponse listOne(int id);

    Page<TeacherResponse> filter(int page, int size, String name, Sort.Direction direction);

    TeacherResponse create(TeacherRequest teacherRequest);

    TeacherResponse update(TeacherRequest teacherRequest, Long id);

    void delete(Long id);
}
