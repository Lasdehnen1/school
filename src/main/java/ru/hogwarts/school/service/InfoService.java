package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class InfoService {
    @Value("${server.port}")
    private Integer serverPort;


    public Integer getServerPort() {
        return serverPort;
    }

    public Integer count() {
        int sum = Stream
                .iterate(1, a -> a + 1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, (a, b) -> a + b);
        return sum;
    }
}
