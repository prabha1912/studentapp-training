package com.praba.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.praba.studentapp.model.Student;
import com.praba.studentapp.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImp implements StudentService {

	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> findStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public Optional<Student> findStudentById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public String deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return "success";

	}

}
