package com.school.demo.ServiceImplimentation;

import com.school.demo.DAO.StudentDAO;
import com.school.demo.Service.StudentService;
import com.school.demo.entity.Student;
import com.school.demo.exception.NoSuchStudentExistsException;
import com.school.demo.exception.StudentAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImplimentation implements StudentService {
@Autowired
public StudentDAO studentDAO;

    @Override
    public Student addStudent(Student student) throws StudentAlreadyExistsException {


            if (studentDAO.existsById(student.getId())) {
                throw new StudentAlreadyExistsException();
            }
            Student savedBlog = studentDAO.save(student);
            return savedBlog;
        }


//        return studentDAO.save(student);


    @Override
    public List<Student> getAllByStudent() {
        return studentDAO.findAll();
    }

    @Override
    public Student findByid(Integer id) throws NoSuchStudentExistsException {
        Student student;

        if (studentDAO.findById(id).isEmpty()) {

            throw new NoSuchStudentExistsException();
        }
        else {
            student= studentDAO.findById(id).get();
        }
        return student;

    }
//
//    @Override
//    public String findFirstnameByid(Integer id) {
//        return studentDAO.findFirstnameByid(id);
//    }
//
//    @Override
//    public List<Object[]> findfirstandlastnameByid(Integer id) {
//        return studentDAO.findfirstandlastnameByid(id);
//    }

    @Override
    public Student update(Student student) throws NoSuchStudentExistsException {
        return studentDAO.save(student);
    }

    @Override
    public String delete(Integer id) throws NoSuchStudentExistsException {

        if(studentDAO.findById(id).isEmpty()){
            throw new NoSuchStudentExistsException();
        }else {
            studentDAO.deleteById(id);
        }
//         studentDAO.deleteById(id);
         return "data deleted successfully";

    }


}
