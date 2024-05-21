package com.QrCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QrCode.model.Student;

public interface StudentRepository  extends JpaRepository<Student,Integer>{

}
