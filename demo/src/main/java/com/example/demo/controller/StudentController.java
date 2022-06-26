package com.example.demo.controller;
import com.example.demo.exception.StudentException;
import com.example.demo.entity.Student;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class StudentController {
    @Autowired
    private com.example.demo.service.StudentService studentService;

    // Save operation
    @PostMapping("/save-students")
    public Student saveStudent(@Valid @RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    // Read operation
    @GetMapping("/students")
    public List<Student> fetchStudentList()
    {
        return studentService.fetchStudentList();
    }
    // Update operation
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }
    // Delete operation
    @GetMapping ("/delete-student/{id}")
    public String deleteStudentById(@PathVariable("id") Integer studentId)
    {
        studentService.deleteStudentById(studentId);
        return "Deleted Successfully";
    }
    @GetMapping ("/get-student/{id}")
    public Student searchStudentById(@PathVariable("id") Integer studentId) throws StudentException {
       return studentService.searchStudentById(studentId);

    }

}