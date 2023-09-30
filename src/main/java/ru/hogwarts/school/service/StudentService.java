package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.entity.Student;
import ru.hogwarts.school.repository.StudentRepository;


import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public Student addStudent(Student student) {
        logger.info("Was invoked method for creating student");
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        logger.info("Was invoked method for getting student by id: {}", id);
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        logger.info("Was invoked method for editing student");
        return studentRepository.save(student);
    }

    public void removeStudent(Long id) {
        logger.info("Was invoked method for deleting student: {}", id);
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAll() {
        logger.info("Was invoked method for finding all students");
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge(int age) {
        logger.info("Was invoked method for getting student by age: {}", age);
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        logger.info("Was invoked method for getting student by age between: {}, {}", min, max);
        return studentRepository.findByAgeBetween(min, max);
    }
    public Faculty getFaculty(Long studentId) {
        logger.info("Was invoked method for getting faculty by studentId: {}", studentId);
        return studentRepository.findById(studentId).get().getFaculty();
    }

    public List<Student> findByFacultyId(Long facultyId) {
        logger.info("Was invoked method for getting faculty by facultyId: {}", facultyId);
        return studentRepository.findByFacultyId(facultyId);
    }

    public Integer studentQuantity() {
        logger.info("Was invoked method for getting student quantity");
        return studentRepository.allStudentsQuantity();
    }

    public double averageAge() {
        logger.info("Was invoked method for getting student average age");
        return studentRepository.averageAge();
    }

    public List<Student> lastFive() {
        logger.info("Was invoked method for getting last five students");
        return studentRepository.lastFive();
    }

}
