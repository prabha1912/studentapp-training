package com.praba.studentapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praba.studentapp.exception.StudentNotFoundException;
import com.praba.studentapp.model.Student;
import com.praba.studentapp.service.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	@Autowired
	private StudentService studentservice;

	/*
	 * @GetMapping("/{name}") public ResponseEntity<?>
	 * getStudentByName(@PathVariable("name") String name) {
	 * 
	 * return new ResponseEntity<>(studentservice.findStudentByName(name),
	 * HttpStatus.FOUND); }
	 */
   // Get mapping comment to check git commit
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(studentservice.findStudentById(id), HttpStatus.FOUND);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException snfe) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(snfe.getMessage());
	}

	@PostMapping()
	public ResponseEntity<?> createStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<String, String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(studentservice.createStudent(student), HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentservice.createStudent(student), HttpStatus.OK);
	}

	@GetMapping()
	public List<Student> getAllStudent() {
		return studentservice.getAllStudent();
	}

	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable("id") Long id) {
		studentservice.deleteStudentById(id);
	}
}