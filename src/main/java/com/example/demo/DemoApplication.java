package com.example.demo;

import com.example.demo.department.DepartDAO;
import com.example.demo.department.DepartamentEntity;
import javafx.application.Application;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init(DepartDAO departDAO) {
//        return args -> {
//            Stream.of(
//                    "HR",
//                    "Tech",
//                    "Finance",
//                    "Develop"
//            ).forEach(depName -> {
//                DepartamentEntity depEntity = new DepartamentEntity();
//                depEntity.setDpName(depName);
//                departDAO.save(depEntity);
//            });
//        };
//    }

}
