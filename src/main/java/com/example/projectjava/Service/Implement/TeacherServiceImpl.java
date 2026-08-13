package com.example.projectjava.Service.Implement;

import com.example.projectjava.DTO.TeacherRequest;
import com.example.projectjava.DTO.TeacherResponse;
import com.example.projectjava.Model.Teacher;
import com.example.projectjava.Repository.TeacherRepository;
import com.example.projectjava.Service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;

    @Override
    public List<TeacherResponse> list() {
        return teacherRepository.findAll().stream().map(Teacher::toResponse).toList();
    }

    @Override
    public TeacherResponse listOne(int id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
        return teacher.toResponse();
    }

    @Override
    public Page<TeacherResponse> filter(int page, int size, String name, Sort.Direction direction) {
        Sort sort = Sort.by(direction, "id").and(Sort.by(direction, "name"));

        PageRequest pageable = PageRequest.of(page - 1, size, sort);

        if(StringUtils.hasText(name)){
            return teacherRepository.searchTeacherByNameContainingIgnoreCase(name, pageable).map(Teacher::toResponse);
        }

        return teacherRepository.searchTeacherByNameContainingIgnoreCase(name, pageable).map(Teacher::toResponse);
    }

    @Override
    public TeacherResponse create(TeacherRequest teacherRequest) {
        return teacherRepository.save(teacherRequest.toEntity()).toResponse();
    }

    @Override
    public TeacherResponse update(TeacherRequest teacherRequest, Long id) {
        Teacher teacher = teacherRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
        teacher.setName(teacherRequest.getName());
        teacher.setGender(teacherRequest.getGender());
        teacher.setAge(teacherRequest.getAge());
        teacher.setClassTeach(teacherRequest.getClassTeach());
        return teacherRepository.save(teacher).toResponse();
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = teacherRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
        teacherRepository.delete(teacher);
    }
}
