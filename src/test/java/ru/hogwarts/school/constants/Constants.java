package ru.hogwarts.school.constants;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Constants {

    public static final Student TEST_STUDENT_1 = new Student(1L, "Ivan", 22);
    public static final Student TEST_STUDENT_2 = new Student(2L, "Maxim", 23);
    public static final Student TEST_STUDENT_3 = new Student(3L, "Roman", 24);
    public static final Student TEST_STUDENT_4 = new Student(4L, "Evgenii", 22);

    public static final Collection<Student> TEST_STUDENT_COLLECTION = new ArrayList<>(List.of(
            TEST_STUDENT_1,
            TEST_STUDENT_2,
            TEST_STUDENT_3,
            TEST_STUDENT_4));
    public static final Faculty TEST_FACULTY_1 = new Faculty(1L, "Gryffindor", "Red");
    public static final Faculty TEST_FACULTY_2 = new Faculty(2L, "Hufflepuff", "Yellow");
    public static final Faculty TEST_FACULTY_3 = new Faculty(3L, "Ravenclaw", "Blue");
    public static final Faculty TEST_FACULTY_4 = new Faculty(4L, "Slytherin", "Green");
    public static final Collection<Faculty> TEST_FACULTY_COLLECTION = new ArrayList<>(List.of(
            TEST_FACULTY_1,
            TEST_FACULTY_2,
            TEST_FACULTY_3,
            TEST_FACULTY_4));

}
