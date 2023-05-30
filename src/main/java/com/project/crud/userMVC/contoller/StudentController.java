package com.project.crud.userMVC.contoller;
import com.project.crud.userMVC.constants.Constants;
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

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
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
    public String deleteById(@PathVariable(value = "id") long id) {
        Boolean is_Delete=studentService.deleteById(id);
        if(is_Delete){
            return Constants.SUCCESS_SOFT_DELETED.getName();
        }
        return Constants.FAIL_SOFT_DELETED.getName();
    }

    //hard delete
    @DeleteMapping("hard/{id}")
    public String hardDeleteById(@PathVariable(value = "id") long id) {

        Boolean is_Delete=studentService.hardDeleteById(id);
        if(is_Delete){
            return Constants.SUCCESS_CURRENT_DELETED.getName();
        }
        return Constants.FAIL_CURRENT_DELETED.getName();
    }


    //hard delete
    @DeleteMapping
    public String hardDeleteAllStudents(){
        Boolean is_Deleted=studentService.hardDeleteAllStudents();
        if(is_Deleted){
            return Constants.SUCCESS_ALL_DELETED.getName();
        }
        return Constants.FAIL_ALL_DELETED.getName();
    }
    
}