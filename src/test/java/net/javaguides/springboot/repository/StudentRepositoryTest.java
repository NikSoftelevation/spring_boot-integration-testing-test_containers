package net.javaguides.springboot.repository;

import net.javaguides.springboot.AbstractContainerBaseTest;
import net.javaguides.springboot.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Student repository test.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest extends AbstractContainerBaseTest {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Given student object when save then return saved student.
     */
//Junit test case for save student operation
    @Test
    public void givenStudentObject_whenSave_thenReturnSavedStudent(){

        //given
        Student student=Student
                                .builder()
                                .firstName("Ram")
                                .lastName("Kumar")
                                .email("ramesh@gmail.com")
                                .build();
        //when
       Student savedStudent = studentRepository.save(student);

        //then
        Assertions.assertNotNull(savedStudent);
        Assertions.assertNotNull(savedStudent.getId());
    }

    /**
     * Given student id when find by id then return saved student.
     */
    @Test
    public void givenStudentId_whenFindById_thenReturnSavedStudent()
    {
        //given
        Student student = Student
                                  .builder()
                                  .firstName("Nikhil")
                                  .lastName("Sharma")
                                  .email("nikhil.softelevation@gmail.com")
                                  .build();
        Student savedStudent = studentRepository.save(student);

        //when
        Student studentDB = studentRepository.findById(student.getId()).get();

        //then
        Assertions.assertNotNull(studentDB);
    }
    }