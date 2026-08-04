package com.example.projectjava.Repository;

import com.example.projectjava.Model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.QAbstractAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "select t from Teacher t where :name is null or :name = '' or lower(t.name) like lower(concat('%', :name, '%'))")
    Page<Teacher> searchTeacherByNameContainingIgnoreCase(String name, PageRequest pageable);
}
