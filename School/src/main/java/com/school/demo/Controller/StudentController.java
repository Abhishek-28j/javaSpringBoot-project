package com.school.demo.Controller;

import com.school.demo.Service.StudentService;
import com.school.demo.entity.Student;
import com.school.demo.exception.ErrorResponse;
import com.school.demo.exception.NoSuchStudentExistsException;
import com.school.demo.exception.StudentAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import com.school.demo.exception;

import java.util.List;
@RestController
public class StudentController {
    @Autowired
    public StudentService studentService;
    @PostMapping("add")
    public ResponseEntity getstudent(@RequestBody Student student) throws StudentAlreadyExistsException {
        Student savedBlog =studentService.addStudent(student);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }


    @GetMapping("Student")
    public List<Student> getAll()
    {
        return studentService.getAllByStudent();
    }

    @GetMapping("student/{id}")
    public ResponseEntity findByid(@PathVariable Integer id) throws NoSuchStudentExistsException{
        Student savedBlog = studentService.findByid(id);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }


    @PutMapping("Student/{id}/{firstname}")
    public ResponseEntity updatefirstname(@RequestBody Student student) throws NoSuchStudentExistsException
    {
        return new ResponseEntity(studentService.update(student), HttpStatus.OK);
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity deletefirstname(@PathVariable Integer id) throws NoSuchStudentExistsException
    {
        return new ResponseEntity(studentService.delete(id), HttpStatus.OK);
    }


@ExceptionHandler(value = StudentAlreadyExistsException.class)
@ResponseStatus(HttpStatus.CONFLICT)
public ErrorResponse UserAlreadyExistsException(StudentAlreadyExistsException studentAlreadyExistsException) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), "user already exists");
}
    @ExceptionHandler(value = NoSuchStudentExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse NosuchExistsException(NoSuchStudentExistsException  noSuchStudentExistsException) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), "Not found");
    }
}

