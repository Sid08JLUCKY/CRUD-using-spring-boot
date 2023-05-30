package com.project.crud.userMVC.contoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.project.crud.userMVC.model.*;
import com.project.crud.userMVC.service.*;
import java.util.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
        
    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable(value = "id") long id) {
    	return studentService.findStudentById(id);
    }

    @PostMapping
    public Student saveStudent(@Validated @RequestBody Student student) {
    	return studentService.saveStudent(student);
    }
    
    @PutMapping
    public Student updateStudent(@Validated @RequestBody Student student) {
    	return studentService.updateStudent(student);
    }

    //soft delete
    @DeleteMapping("soft/{id}")
    public boolean deleteById(@PathVariable(value = "id") long id) {
        return studentService.deleteById(id);
    }

    //hard delete
    @DeleteMapping("hard/{id}")
    public boolean hardDeleteById(@PathVariable(value = "id") long id) {
    	return studentService.hardDeleteById(id);
    }


    //hard delete
    @DeleteMapping
    public boolean hardDeleteAllStudents(){return studentService.hardDeleteAllStudents();}
    
}