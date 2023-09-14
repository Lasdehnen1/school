package ru.hogwarts.school.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.entity.Student;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        assertThat(studentController).isNotNull();
    }
    @Test
    void getAllStudentsTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/all", String.class))
                .isNotNull();
    }

    @Test
    void testAddStudent() throws Exception {

        Student student = new Student();
        student.setAge(22);
        student.setName("Name");

        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                                .isNotNull();

    }

    @Test
    void editStudentTest() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Student student1 = new Student();
        student1.setName("Name");
        student1.setAge(22);
        student1.setId(1L);

        Student student2 = new Student();
        student2.setName("Name1");
        student2.setAge(23);
        student2.setId(1L);

        HttpEntity<Student> entity = new HttpEntity<>(student1, headers);

        this.restTemplate.put("http://localhost:" + port + "/student", student1);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/1", Student.class)).isEqualTo(student1);
        this.restTemplate.put("http://localhost:" + port + "/student", student2);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/1", Student.class)).isEqualTo(student2);
        ResponseEntity<Student> response = restTemplate.exchange("http://localhost:" + port + "/student", HttpMethod.PUT, entity, Student.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void findStudentsByIdTest() throws Exception {
        Student student = new Student();
        student.setAge(0);
        student.setName(null);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/1", Student.class))
                .isNotNull();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/100", Student.class))
                .isEqualTo(student);
    }

    @Test
    void findStudentByAgeTest() throws Exception {
        Collection<Student> emptyList = new ArrayList<>();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/age?age=22", Collection.class))
                .isNotNull();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/age?age=100", Collection.class))
                .isEqualTo(emptyList);
    }
    @Test
    void findStudentsByAgeBetweenTest() throws Exception {
        Collection<Student> emptyList = new ArrayList<>();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/find?min=22&max=24", Collection.class))
                .isNotNull();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/find?min=50&max=100", Collection.class))
                .isEqualTo(emptyList);
    }

    @Test
    void findFacultyById() {
        Collection<Student> emptyList = new ArrayList<>();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/find-by-id?id=3", Faculty.class))
                .isNotNull();
    }
}