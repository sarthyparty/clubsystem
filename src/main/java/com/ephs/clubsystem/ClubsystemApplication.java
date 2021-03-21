package com.ephs.clubsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class ClubsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubsystemApplication.class, args);
    }

}
