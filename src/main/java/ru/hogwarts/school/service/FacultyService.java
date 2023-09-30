package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jca.cci.object.SimpleRecordOperation;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.entity.Student;
import ru.hogwarts.school.repository.FacultyRepository;


import java.util.Collection;
import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final StudentService studentService;

    public FacultyService(FacultyRepository facultyRepository, StudentService studentService) {
        this.facultyRepository = facultyRepository;
        this.studentService = studentService;
    }
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public Faculty addFaculty(Faculty faculty) {
        logger.info("Was invoked method for adding faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long id) {
        logger.info("Was invoked method for getting faculty by id");
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("Was invoked method for editing faculty");
        return facultyRepository.save(faculty);
    }

    public void removeFaculty(Long id) {
        logger.info("Was invoked method for removing faculty");
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> getAll() {
        logger.info("Was invoked method for getting all faculties");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultyByColor(String color) {
        logger.info("Was invoked method for getting faculty by color");
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> findFacultyByNameOrColor(String param) {
        logger.info("Was invoked method for getting faculty by name or color");
        return facultyRepository.findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(param, param);
    }

    public List<Student> getStudents(Long id) {
        logger.info("Was invoked method for getting faculty by student id");
        return studentService.findByFacultyId(id);
    }

}
