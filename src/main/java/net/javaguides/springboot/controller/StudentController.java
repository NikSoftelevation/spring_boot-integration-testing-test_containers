package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Student controller.
 */
@RestController
@RequestMapping("/api/students")
public class StudentController
{
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Create student student.
     *
     * @param student the student
     * @return the student
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
      return studentRepository.save(student);
    }

    /**
     * Get all students list.
     *
     * @return the list
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}