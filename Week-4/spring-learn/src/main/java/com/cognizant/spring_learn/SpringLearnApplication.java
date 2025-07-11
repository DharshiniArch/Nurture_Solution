package com.cognizant.spring_learn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringLearnApplication {
    public static void main(String[] args) {
        System.out.println("🚀 Starting Spring Boot App on port 8090...");
        SpringApplication.run(SpringLearnApplication.class, args);
    }
}
