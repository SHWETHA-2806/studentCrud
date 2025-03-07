package com.example.democrudprojecttwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.democrudprojecttwo.model.Student;
import com.example.democrudprojecttwo.service.StudentService;

@RestController
@RequestMapping("/student")
public class studentController {

	@Autowired 
	private StudentService studentService;
	
	@PostMapping
	public Student save(@RequestBody Student student)
	{
		return studentService.save(student);
	}
	
	@GetMapping
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable String id)
	{
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudentById(@PathVariable String id)
	{
		return studentService.deleteStudentById(id);
	}
	
}
