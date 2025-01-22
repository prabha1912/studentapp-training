package com.praba.studentapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praba.studentapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByName(String name);

}
