package com.project.crud.userMVC.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.project.crud.userMVC.model.*;
import com.project.crud.userMVC.repository.StudentRepository;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public ResponseEntity<List<Student>> findAllStudents(){
		List<Student>students=studentRepository.findAll();
		System.out.println(students);
		if(students.isEmpty()){
			System.out.println(ResponseEntity.notFound().build());
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(students);
	}

    public ResponseEntity<Student> findStudentById(@PathVariable(value = "id") long id) {
    	Optional<Student> stud= studentRepository.findById(id);
		return stud.map(student -> ResponseEntity.ok().body(student)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Student saveStudent(@Validated @RequestBody Student student) {

		return studentRepository.save(student);
    }
    
    public Student updateStudent(@Validated @RequestBody Student student) {
    	Student stud= studentRepository.getReferenceById(student.getId());

		stud.setName(student.getName());
		stud.setAge(student.getAge());
		stud.setCgpa(student.getCgpa());
		stud.setProfileImg(student.getProfileImg());
		return studentRepository.save(stud);
	}
    
    public Boolean deleteById(@PathVariable(value = "id") long id) {
		if(studentRepository.findById(id).isEmpty()){
			return Boolean.FALSE;
		}
		Student stud=studentRepository.getReferenceById(id);
		stud.setIs_deleted(Boolean.TRUE);
		studentRepository.save(stud);
    	return Boolean.TRUE;
    }

	public Boolean hardDeleteById(@PathVariable(value = "id") long id) {
		if(studentRepository.findById(id).isEmpty()){
			return Boolean.FALSE;
		}
		studentRepository.deleteById(id);
		return Boolean.TRUE;
	}

	public Boolean hardDeleteAllStudents(){
		if(studentRepository.findAll().isEmpty()){
			return Boolean.FALSE;
		}
		studentRepository.deleteAll();
		return Boolean.TRUE;
	}
}