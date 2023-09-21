package ru.hogwarts.school.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.entity.Student;

import java.util.Collection;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    List<Student> findByFacultyId(Long id);

    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer allStudentsQuantity();

    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    double averageAge();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> lastFive();

}
