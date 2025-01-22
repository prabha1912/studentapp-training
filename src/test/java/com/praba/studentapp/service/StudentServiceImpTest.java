package com.praba.studentapp.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.praba.studentapp.model.Student;
import com.praba.studentapp.repository.StudentRepository;
import com.praba.studentapp.service.StudentService;
import com.praba.studentapp.service.StudentServiceImp;

class StudentServiceImpTest {
	
	@Mock
	 StudentRepository studentRepository;
	 StudentService studentService;
	 Student student;
	 AutoCloseable autoCloseable;
	 long id=51;
	 

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable=MockitoAnnotations.openMocks(this);
		studentService=new StudentServiceImp(studentRepository);
		student = new Student((long) 51, "Adharshna", "adharshna@gmail.com", "1234");
	}

	@AfterEach
	void tearDown() throws Exception {
		
		autoCloseable.close();
	}

	@Test
	void test_createStudent() {
		mock(Student.class);
		mock(StudentRepository.class);
		
		studentService.createStudent(student);
		//verify(studentRepository, times(1).save(any()));
	
		ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);
		verify(studentRepository).save(captor.capture());
		assertTrue(captor.getValue().getName().equals(student.getName()));
	}
	@Test
	void test_findStudentById()
	{
		mock(Student.class);
		mock(StudentRepository.class);
		
		
		when(studentService.findStudentById(id)).thenReturn(Optional.ofNullable(student));
		assertEquals(studentService.findStudentById(id).get().getName(),student.getName());
	}
	
	@Test
	void test_findStudentByName()
	{
		mock(Student.class);
		mock(StudentRepository.class);
		
		when(studentService.findStudentByName("Adharshna")).thenReturn(Optional.ofNullable(student));
		assertEquals(studentService.findStudentByName("Adharshna").get().getEmail(),student.getEmail());
	}
	
	@Test
	
	void test_getAllStudent()
	{
		mock(Student.class);
		
		when(studentService.getAllStudent()).thenReturn(new ArrayList<Student>(Collections.singletonList(student)));
		assertThat(studentService.getAllStudent().get(0).getName()).isEqualTo(student.getName());
	}
	
	@Test
	void test_deleteStudentById()
	{
		mock(Student.class);
		mock(StudentRepository.class,Mockito.CALLS_REAL_METHODS);
		
		doAnswer(Answers.CALLS_REAL_METHODS).when(studentRepository)
											.deleteById(any());
		assertThat(studentService.deleteStudentById(id)).isEqualTo("success");
	}
	
	

}
