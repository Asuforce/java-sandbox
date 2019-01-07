package com.example.javacrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JavaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCrudApplication.class, args);
    }
}
