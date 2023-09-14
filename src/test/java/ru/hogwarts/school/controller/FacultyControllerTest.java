package ru.hogwarts.school.controller;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.AvatarService;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.service.StudentService;


import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.hogwarts.school.constants.Constants.*;

@WebMvcTest
class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyRepository facultyRepository;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private AvatarRepository avatarRepository;

    @SpyBean
    private FacultyService facultyService;

    @SpyBean
    private StudentService studentService;

    @SpyBean
    private AvatarService avatarService;

    @InjectMocks
    private FacultyController facultyController;


    @Test
    void getFacultyInfoById() throws Exception {

        Faculty faculty = new Faculty();
        faculty.setId(TEST_FACULTY_1.getId());
        faculty.setName(TEST_FACULTY_1.getName());
        faculty.setColor(TEST_FACULTY_1.getColor());
        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
        when(facultyRepository.findById(any(Long.class))).thenReturn(Optional.of(faculty));


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/" + TEST_FACULTY_1.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(TEST_FACULTY_1.getId()))
                .andExpect(jsonPath("$.name").value(TEST_FACULTY_1.getName()))
                .andExpect(jsonPath("$.color").value(TEST_FACULTY_1.getColor()));

    }

    @Test
    void addFaculty() throws Exception {

        JSONObject userObject = new JSONObject();
        userObject.put("name", TEST_FACULTY_1.getName());
        Faculty faculty = new Faculty();
        faculty.setId(TEST_FACULTY_1.getId());
        faculty.setName(TEST_FACULTY_1.getName());
        faculty.setColor(TEST_FACULTY_1.getColor());
        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
        when(facultyRepository.findById(any(Long.class))).thenReturn(Optional.of(faculty));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculty") //send
                        .content(userObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) //receive
                .andExpect(jsonPath("$.id").value(TEST_FACULTY_1.getId()))
                .andExpect(jsonPath("$.name").value(TEST_FACULTY_1.getName()))
                .andExpect(jsonPath("$.color").value(TEST_FACULTY_1.getColor()));
    }

    @Test
    void editFaculty() throws Exception {
        JSONObject facultyObject = new JSONObject();
        facultyObject.put("id", TEST_FACULTY_1.getId());
        facultyObject.put("name", TEST_FACULTY_1.getName());
        facultyObject.put("color", TEST_FACULTY_1.getColor());

        when(facultyRepository.save(any(Faculty.class))).thenReturn(TEST_FACULTY_1);
        when(facultyRepository.findById(any(Long.class))).thenReturn(Optional.of(TEST_FACULTY_1));

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) //receive
                .andExpect(jsonPath("$.id").value(TEST_FACULTY_1.getId()))
                .andExpect(jsonPath("$.name").value(TEST_FACULTY_1.getName()))
                .andExpect(jsonPath("$.color").value(TEST_FACULTY_1.getColor()));

    }

    @Test
    void deleteFaculty() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/faculty" + "/" + TEST_FACULTY_1.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {
        when(facultyRepository.findAll()).thenReturn((List<Faculty>) TEST_FACULTY_COLLECTION);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(TEST_FACULTY_COLLECTION.size()))
                .andExpect(jsonPath("$.[0].name").value(TEST_FACULTY_1.getName()))
                .andExpect(jsonPath("$.[1].name").value(TEST_FACULTY_2.getName()))
                .andExpect(jsonPath("$.[2].name").value(TEST_FACULTY_3.getName()))
                .andExpect(jsonPath("$.[3].name").value(TEST_FACULTY_4.getName()))
                .andExpect(jsonPath("$.[0].color").value(TEST_FACULTY_1.getColor()))
                .andExpect(jsonPath("$.[1].color").value(TEST_FACULTY_2.getColor()))
                .andExpect(jsonPath("$.[2].color").value(TEST_FACULTY_3.getColor()))
                .andExpect(jsonPath("$.[3].color").value(TEST_FACULTY_4.getColor()));
    }

    @Test
    void findFacultiesByColor() throws Exception {


        when(facultyRepository.findByColor(anyString())).thenReturn(TEST_FACULTY_COLLECTION);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/color?color=" + TEST_FACULTY_1.getColor())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].color").value(TEST_FACULTY_1.getColor()));


    }

    @Test
    void findByNameOrColor() throws Exception {


        when(facultyRepository.findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(any(), any())).thenReturn(TEST_FACULTY_COLLECTION);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/find?param=" + TEST_FACULTY_1.getColor())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].color").value(TEST_FACULTY_1.getColor()));


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/find?param=" + TEST_FACULTY_1.getName())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(TEST_FACULTY_1.getName()));
    }

}