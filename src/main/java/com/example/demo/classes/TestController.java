package com.example.demo.classes;

import com.example.demo.annotation.EncodeBase64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @EncodeBase64
    @ResponseBody
    @GetMapping("/{param}")
    public String test(@PathVariable("param") String param) {
        testService.printParam(param);
        return "test";
    }
}
