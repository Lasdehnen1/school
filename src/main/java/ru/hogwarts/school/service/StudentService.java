package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long nextId = 0L;

    public Student addStudent(String name, int age) {
        Student newStudent = new Student(++nextId, name, age);
        students.put(newStudent.getId(), newStudent);
        return newStudent;
    }

    public Student getStudentById(Long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        if (!students.containsKey(student.getId())) {
            return null;
        }
        students.put(student.getId(), student);
        return student;
    }

    public Student removeStudent(Long id) {
        return students.remove(id);
    }

    public Collection<Student> getAll() {
        return students.values();
    }
    public Collection<Student> findByAge(int age) {
        return students.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }


}
