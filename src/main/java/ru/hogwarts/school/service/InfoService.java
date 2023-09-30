package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    @Value("${server.port}")
    private Integer serverPort;


    public Integer getServerPort() {
        return serverPort;
    }
}
