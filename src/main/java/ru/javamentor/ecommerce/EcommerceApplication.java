package ru.javamentor.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EcommerceApplication {
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }
}
