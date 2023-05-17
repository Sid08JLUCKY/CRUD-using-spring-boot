package com.project.crud.userMVC.model;
import org.hibernate.annotations.Table;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.*;

@Entity
@Table(appliesTo="student")
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private Integer age;
	private String profileImg;
	private Float cgpa;

	public Student(){}

	public Student(long id,String name,Integer age,String profileImg,Float cgpa) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.profileImg=profileImg;
		this.cgpa=cgpa;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(Integer age) {
		this.age=age;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg=profileImg;
	}
	public void setCgpa(Float cgpa) {
		this.cgpa=cgpa;
	}
	

	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public Integer getAge() {
		return this.age;
	}
	public String getProfileImg() {
		return this.profileImg;
	}
	public Float getCgpa() {
		return this.cgpa;
	}
	
	
}