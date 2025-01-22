package com.praba.studentapp.service;

import java.util.List;
import java.util.Optional;

import com.praba.studentapp.model.Student;

public interface StudentService {

	Student createStudent(Student student);

	Optional<Student> findStudentByName(String name);

	Optional<Student> findStudentById(Long id);

	List<Student> getAllStudent();

	String deleteStudentById(Long id);
}
