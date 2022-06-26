package com.example.demo.service;

import com.example.demo.exception.StudentException;
import com.example.demo.entity.Student;
import java.util.List;
public interface StudentService {
    Student saveStudent(Student student);

    List<Student> fetchStudentList();

    Student updateStudent(Student student);

    // Delete operation
    void deleteStudentById(Integer studentId);
    Student searchStudentById(Integer studentId) throws StudentException;
}
