package com.example.demo.classes;

import com.example.demo.annotation.Timer;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Timer
    public void printParam(String str) {
        System.out.println("param in TestService: " + str);
    }
}
