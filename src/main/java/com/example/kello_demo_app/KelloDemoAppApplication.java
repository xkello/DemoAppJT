package com.example.kello_demo_app;

import com.example.kello_demo_app.model.User;
import com.example.kello_demo_app.model.VacationRequest;
import com.example.kello_demo_app.repository.UserRepository;
import com.example.kello_demo_app.repository.VacationRequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class KelloDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(KelloDemoAppApplication.class, args);
    }
}


