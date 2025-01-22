package com.praba.studentapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.praba.studentapp.controller.StudentController;
import com.praba.studentapp.model.Student;
import com.praba.studentapp.service.StudentService;


@WebMvcTest(StudentController.class)
class StudentControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	StudentService studentService;
	Optional<Student> studentOp;
	
	Student studentOne;
	Student studentTwo;
	List<Student> studentList=new ArrayList<>();
	long id1=1, id2=51, id3=101;
	
	@BeforeEach
	void setup()
	{
		studentOp=Optional.ofNullable(new Student(id3,"Praba","Praba@gmail.com","12345"));
		studentOne=new Student(id1,"Aghna","aghna@gmail.com","123");
		studentTwo=new Student(id2,"Adharshna","Adharshna@gmail.com","1234");
		
		studentList.add(studentOne);
		studentList.add(studentTwo);
	}
	
	@AfterEach
	void tearDown()
	{
		
	}

	@Test
	void test_getStudentById() throws Exception {
		
		
		/*
		 * when(studentService.findStudentById(id3)) .thenReturn(studentOp);
		 * this.mockMvc.perform(get("/api/v1/students/101")) .andDo(print())
		 * .andExpect(status().isOk());
		 */
	}
	
	@Test
	void test_getAllStudent() throws Exception{
		
		
		  when(studentService.getAllStudent()) .thenReturn(studentList);
		  this.mockMvc.perform(get("/api/v1/students")) .andDo(print())
		  .andExpect(status().isOk());
		 
	}
	
	@Test
	void test_deleteStudentById() throws Exception{
		
		
		  when(studentService.deleteStudentById(id3)) .thenReturn("success");
		  this.mockMvc.perform(get("/api/v1/students/101")) .andDo(print())
		  .andExpect(status().isOk());
		 
		 
	}
	
	

}
