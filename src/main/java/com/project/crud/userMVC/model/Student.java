package com.project.crud.userMVC.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;
import jakarta.persistence.*;
import org.hibernate.annotations.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(appliesTo="student")
@SQLDelete(sql = "UPDATE student SET is_deleted=true WHERE id=?")
@Where(clause = "is_deleted = false")
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private Integer age;
	private String profileImg;
	private Float cgpa;
	@Builder.Default private Boolean is_deleted=Boolean.FALSE;
}