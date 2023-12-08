package com.school.demo.Service;

import com.school.demo.entity.Student;

import java.util.List;

public interface StudentService {
   public Student addStudent(Student student);
   public List<Student> getAllByStudent();
   public Student findByid(Integer id);
//   public String findFirstnameByid(Integer id);
//   public List<Object[]> findfirstandlastnameByid(Integer id);
   public Student update(Student student);
   public String delete(Integer id);
}
