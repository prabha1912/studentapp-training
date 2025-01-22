package com.praba.studentapp.repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.praba.studentapp.model.Student;
import com.praba.studentapp.repository.StudentRepository;

@DataJpaTest
class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;
	Student student;

	@BeforeEach
	void setUp() {
		student = new Student((long) 51, "Adharshna", "adharshna@gmail.com", "1234");
		studentRepository.save(student);
	}

	@AfterEach
	void tearDown() {
		student = null;
		studentRepository.deleteAll();
	}

	// Test Case Success
	@Test
	void test_findByName_returnFound() {
		Optional<Student> studentResult = studentRepository.findByName("Adharshna");
		assertEquals(studentResult.get().getName(),student.getName());
		assertEquals(studentResult.get().getEmail(), student.getEmail());
		assertEquals(studentResult.get().getPassword(),student.getPassword());
	}

	// Test Case Failure
	
	@Test
	void test_findByName_returnNotFound()
	{
		Optional<Student> studentResult= studentRepository.findByName("xxx");
		assertThat(studentResult.isEmpty());
		
	}
	
}
