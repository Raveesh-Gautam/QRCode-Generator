package com.QrCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QrCode.model.Student;
import com.QrCode.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	@Autowired
	private  StudentRepository  StudentRepository;
	
	public List<Student> getStudents(){
		return this.StudentRepository.findAll();
	}
	
	public Student addStudent(Student student) {
		return this.StudentRepository.save(student);
	}
	
	public Student findById(int id) {
		return this.StudentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
	}
}
