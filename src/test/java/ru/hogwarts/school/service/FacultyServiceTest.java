package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.hogwarts.school.constants.Constants.*;

class FacultyServiceTest {
/*
    FacultyService facultyService = new FacultyService();
    @Test
    void addFaculty() {
        assertEquals(TEST_FACULTY_1, facultyService.addFaculty(TEST_FACULTY_1.getName(), TEST_FACULTY_1.getColor()));
        assertEquals(TEST_FACULTY_2, facultyService.addFaculty(TEST_FACULTY_2.getName(), TEST_FACULTY_2.getColor()));
        assertEquals(TEST_FACULTY_3, facultyService.addFaculty(TEST_FACULTY_3.getName(), TEST_FACULTY_3.getColor()));
        assertEquals(TEST_FACULTY_4, facultyService.addFaculty(TEST_FACULTY_4.getName(), TEST_FACULTY_4.getColor()));
    }

    @Test
    void getFacultyById() {
        addFaculties();
        assertEquals(TEST_FACULTY_1, facultyService.getFacultyById(1L));
        assertEquals(TEST_FACULTY_2, facultyService.getFacultyById(2L));
        assertEquals(TEST_FACULTY_3, facultyService.getFacultyById(3L));
        assertEquals(TEST_FACULTY_4, facultyService.getFacultyById(4L));
        assertNull(facultyService.getFacultyById(5L));
    }

    @Test
    void editFaculty() {
        addFaculties();
        Faculty edited = new Faculty(2L, "Chemistry", "Brown");
        facultyService.editFaculty(edited);
        assertEquals(edited, facultyService.getFacultyById(2L));
    }

    @Test
    void removeFaculty() {
        addFaculties();
        facultyService.removeFaculty(2L);
        assertNull(facultyService.getFacultyById(2L));
    }


    @Test
    void getFacultyByColor() {
        addFaculties();
        Collection<Faculty> expected = new ArrayList<>(List.of(TEST_FACULTY_1));
        Collection<Faculty> actual = facultyService.getFacultyByColor("Red");
        assertEquals(expected, actual);
    }

    private void addFaculties() {
        facultyService.addFaculty(TEST_FACULTY_1.getName(), TEST_FACULTY_1.getColor());
        facultyService.addFaculty(TEST_FACULTY_2.getName(), TEST_FACULTY_2.getColor());
        facultyService.addFaculty(TEST_FACULTY_3.getName(), TEST_FACULTY_3.getColor());
        facultyService.addFaculty(TEST_FACULTY_4.getName(), TEST_FACULTY_4.getColor());

    }

 */


}