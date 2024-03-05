package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		/*
		 * http://localhost:8080/abcd 접속
		 * 
		 * 아래 항목 콘솔에서 확인
		 * 1. param: abcd -> ZmF2aWNvbi5pY28= 로 변환됨
		 * 2. 메서드 실행 시간 출력
		 */
	}

}
