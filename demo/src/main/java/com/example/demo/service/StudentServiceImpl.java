package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.exception.StudentException;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Save operation
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        List<Student> all = studentRepository.findAll();
        return all;
    }

    @Override
    public Student updateStudent(Student updateStudent) {
        return studentRepository.save(updateStudent);
    }

    // Delete operation
    @Override
    public void deleteStudentById(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            Student student1 = student.get();
            student1.setDeleted(true);
            studentRepository.save(student1);
        }
    }
    public Student searchStudentById(Integer studentId) throws StudentException{
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            Student returnStudent = student.get();
            return returnStudent;
        }
        else
        {
            throw new StudentException("Student not found");
        }
    }
}