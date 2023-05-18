package com.project.crud.userMVC.model;
import org.hibernate.annotations.Table;
import jakarta.persistence.*;
import org.hibernate.annotations.*;

@Entity
@Table(appliesTo="student")
@SQLDelete(sql = "UPDATE student SET is_deleted=true WHERE id=?")
@Where(clause = "is_deleted = false")
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private Integer age;
	private String profileImg;
	private Float cgpa;
	private Boolean is_deleted=Boolean.FALSE;

	public Student(){}

	public Student(long id,String name,Integer age,String profileImg,Float cgpa) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.profileImg=profileImg;
		this.cgpa=cgpa;
		this.is_deleted=Boolean.FALSE;
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

	public void setIsDeleted(Boolean currentState){
		this.is_deleted=currentState;
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

	public Boolean getIsDeleted(){return this.is_deleted;}
	
	
}