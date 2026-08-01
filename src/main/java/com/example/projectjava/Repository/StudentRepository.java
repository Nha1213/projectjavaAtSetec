package com.example.projectjava.Repository;

import com.example.projectjava.Model.Student;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query(value = "Select t from Student t where :name is null or :name = '' or lower(t.name) like lower(concat('%', :name, '%'))", nativeQuery = true)
    @Query(value = "Select t from Student t where :name is null or :name = '' or lower(t.name) like lower(concat('%', :name, '%'))")
    Page<Student> searchStudentByNameContainingIgnoreCase(String name, PageRequest pageable);
}
