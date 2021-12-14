package com.bsuir.task.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.bsuir.task.repository.entity")
@EnableJpaRepositories(basePackages = "com.bsuir.task.repository")
@ComponentScan("com.bsuir.task")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
