package ru.hogwarts.school.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.entity.Student;
import ru.hogwarts.school.repository.StudentRepository;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    Object object = new Object();

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

    public List<String> studentListSortedByA() {
        List<String> list = studentRepository.findAll().stream()
                .map(Student::getName)
                .filter(name -> name.contains("A"))
                .sorted()
                .collect(Collectors.toList());
        return list;
    }

    public Double avgStudentAge() {
        Double avgAge = studentRepository.findAll().stream()
                .mapToDouble(Student::getAge)
                .average().getAsDouble();
        return avgAge;

    }

    public void printStudentsNames() {
        List<String> names = studentRepository.findAll().stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(names.get(0));
        System.out.println(names.get(1));
        new Thread(() -> {
            System.out.println(names.get(2));
            System.out.println(names.get(3));
        }).start();
        new Thread(() -> {
            System.out.println(names.get(4));
            System.out.println(names.get(5));
        }).start();
    }

    public void printStudentNamesSynchronized() {
        List<String> names = studentRepository.findAll().stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        synchro(names.get(0));
        synchro(names.get(1));
        new Thread(() -> {
            synchro(names.get(2));
            synchro(names.get(3));
        }).start();
        new Thread(() -> {
            synchro(names.get(4));
            synchro(names.get(5));
        }).start();
    }

    private void synchro(String name) {
        synchronized (object) {
            System.out.println(name);
        }
    }

}
