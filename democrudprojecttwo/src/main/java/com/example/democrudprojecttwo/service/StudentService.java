package com.example.democrudprojecttwo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.democrudprojecttwo.error.StudentNotFoundException;
import com.example.democrudprojecttwo.model.Student;

@Service
public class StudentService {

	List<Student> students = new ArrayList<>();
	
	
	public Student save(Student student) {
		
		if(student.getId()==null)
		{
			student.setId(UUID.randomUUID().toString());
		}
		students.add(student);
		return student;
	}
	
	
	public List<Student> getAllStudents()
	{
		return students;
	}
	
	public Student getStudentById(String id)
	{
		return students
				.stream()
				.filter(student->student.getId().equals(id))
				.findFirst()
				.orElseThrow(()-> new StudentNotFoundException(""+"Student not found"));
						
	}
	
	public String deleteStudentById(String id)
	{
		Student student = students
						  .stream()
						  .filter(e->e.getId().equalsIgnoreCase(id))
						  .findFirst()
						  .get();
		students.remove(student);
		return "Employee Deleted";
						  
	}
	

	
}
