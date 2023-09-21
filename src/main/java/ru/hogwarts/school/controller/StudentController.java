package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.entity.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public Collection<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/age")
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) int age) {

        if (age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }

        return ResponseEntity.ok(Collections.emptyList());
    }



    @GetMapping("/find")
    public ResponseEntity<Collection<Student>> findStudentsByAgeBetween(@RequestParam(required = false) int min,
                                                                        @RequestParam(required = false) int max) {
        if (max > min) {
            return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
        }

        return ResponseEntity.ok(Collections.emptyList());

    }

    @GetMapping("/find-by-id")
    public Faculty findFacultyById(@RequestParam Long id) {
        return studentService.getFaculty(id);
    }

    @GetMapping("/studentQuantity")
    public Integer studentQuantity() {
        return studentService.studentQuantity();
    }

    @GetMapping("/averageAge")
    public double averageAge() {
        return studentService.averageAge();
    }

    @GetMapping("/lastFive")
    public List<Student> lastFive() {
        return studentService.lastFive();
    }
}
