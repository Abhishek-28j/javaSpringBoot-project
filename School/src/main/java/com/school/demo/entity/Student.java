package com.school.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Student")
@Table(name= "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(name ="id")
    private Integer id;
    @Column(name ="firstname")
    private String firstname;
    @Column(name ="lastname")
    private String lastname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "department")
    private String department;
}
