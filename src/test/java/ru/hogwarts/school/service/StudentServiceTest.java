package ru.hogwarts.school.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.repository.StudentRepository;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;
/*
    @Test
    void addStudentsTest() {
        Collection<Student> students = new ArrayList<>();

        when(studentService.getAll()).thenReturn(students);

        assertEquals(TEST_STUDENT_1, studentService.addStudent(TEST_STUDENT_1));
        assertEquals(TEST_STUDENT_2, studentService.addStudent(TEST_STUDENT_2));
        assertEquals(TEST_STUDENT_3, studentService.addStudent(TEST_STUDENT_3));
        assertEquals(TEST_STUDENT_4, studentService.addStudent(TEST_STUDENT_4));

    }

    @Test
    void getStudent() {
        addStudents();
        assertEquals(TEST_STUDENT_1, studentService.getStudentById(1L));
        assertEquals(TEST_STUDENT_2, studentService.getStudentById(2L));
        assertEquals(TEST_STUDENT_3, studentService.getStudentById(3L));
        assertEquals(TEST_STUDENT_4, studentService.getStudentById(4L));
        assertNull(studentService.getStudentById(5L));
    }

    @Test
    void editStudent() {
        addStudents();
        Student editedTest = new Student(1L, "Polo", 25);
        studentService.editStudent(editedTest);
        assertEquals(editedTest, studentService.getStudentById(1L));
    }

    @Test
    void removeStudent() {
        addStudents();
        studentService.removeStudent(1L);
        assertNull(studentService.getStudentById(1L));
    }

    @Test
    void getAll() {
        addStudents();
        Collection<Student> actualCollection = studentService.getAll();
        assertIterableEquals(TEST_STUDENT_COLLECTION, actualCollection);
    }

    @Test
    void findByAge() {
        addStudents();
        Collection<Student> expected = new ArrayList<>(List.of(TEST_STUDENT_3));
        Collection<Student> actual = studentService.findByAge(24);

        assertEquals(expected, actual);
    }

    private void addStudents() {
        studentService.addStudent(TEST_STUDENT_1.getName(), TEST_STUDENT_1.getAge());
        studentService.addStudent(TEST_STUDENT_2.getName(), TEST_STUDENT_2.getAge());
        studentService.addStudent(TEST_STUDENT_3.getName(), TEST_STUDENT_3.getAge());
        studentService.addStudent(TEST_STUDENT_4.getName(), TEST_STUDENT_4.getAge());

    }


 */



}