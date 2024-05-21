package com.QrCode.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QrCode.Qr.QrCodeGenerated;
import com.QrCode.model.Student;
import com.QrCode.service.StudentService;
import com.google.zxing.WriterException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

	private final StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() throws WriterException, IOException{
		List<Student> sts=studentService.getStudents();
		if(sts.size()!=0) {
			for(Student st:sts) {
				QrCodeGenerated.generatedQrCode(st);
			}
		}
		return  ResponseEntity.ok(studentService.getStudents()) ;
	}
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student st){
		return ResponseEntity.ok(studentService.addStudent(st));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable("id") int id){
		return  ResponseEntity.ok(studentService.findById(id)) ;
	}
}
