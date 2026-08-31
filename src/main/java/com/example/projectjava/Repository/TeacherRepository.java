package com.example.projectjava.Repository;

import com.example.projectjava.Model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("""
        SELECT t
        FROM Teacher t
        WHERE :name IS NULL
           OR :name = ''
           OR LOWER(t.name) LIKE LOWER(CONCAT('%', :name, '%'))
        """)
    Page<Teacher> searchTeacherByNameContainingIgnoreCase(
            @Param("name") String name,
            Pageable pageable
    );
}