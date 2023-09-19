package ru.hogwarts.school.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import ru.hogwarts.school.SchoolApplication;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.entity.Student;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(classes = SchoolApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllStudentsTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/all", String.class))
                .isNotNull();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/all", String.class))
                .isNotNull();
    }

    @Test
    void testAddStudent() throws Exception {
        Student student = new Student();
        student.setName("name");
        student.setAge(22);

        ResponseEntity<Student> response = restTemplate.postForEntity("/student", student, Student.class);
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Student resBody = response.getBody();
        assertThat(resBody).isNotNull();
        assertThat(resBody.getId()).isNotNull();
        assertThat(resBody.getName()).isEqualTo("name");
        assertThat(resBody.getAge()).isEqualTo(22);


    }


    @Test
    void editStudentTest() throws Exception {
        Student student = new Student();
        student.setName("name");
        student.setAge(22);

        ResponseEntity<Student> response = restTemplate.postForEntity("/student", student, Student.class);

        Student respBody = response.getBody();

        response = restTemplate.getForEntity("/student/" + respBody.getId(), Student.class);
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        respBody = response.getBody();
        assertThat(respBody).isNotNull();
        assertThat(respBody.getId()).isNotNull();
        assertThat(respBody.getName()).isEqualTo("name");
        assertThat(respBody.getAge()).isEqualTo(22);

    }

    @Test
    void findStudentsByIdTest() throws Exception {
        Student student = new Student();
        student.setName("name");
        student.setAge(22);

        ResponseEntity<Student> response = restTemplate.postForEntity("/student", student, Student.class);

        Student respBody = response.getBody();

        ResponseEntity<Student> response1 = restTemplate.getForEntity("/student/" + respBody.getId(), Student.class);



        assertThat(response1).isNotNull();
        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
        respBody = response1.getBody();
        assertThat(respBody).isNotNull();
        assertThat(respBody.getId()).isNotNull();
        assertThat(respBody.getName()).isEqualTo("name");
        assertThat(respBody.getAge()).isEqualTo(22);

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