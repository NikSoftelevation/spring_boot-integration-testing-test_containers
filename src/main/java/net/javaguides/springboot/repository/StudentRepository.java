package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Student repository.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}