package com.example.demo.classes;

import com.example.demo.annotation.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    @Timer
    public void printParam(String str) {
        log.info("param in TestService: " + str);
    }
}
