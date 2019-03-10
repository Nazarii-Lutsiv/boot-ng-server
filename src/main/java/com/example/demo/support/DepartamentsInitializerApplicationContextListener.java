package com.example.demo.support;

import com.example.demo.department.DepartDAO;
import com.example.demo.department.DepartamentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DepartamentsInitializerApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private final DepartDAO departDAO;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (departDAO.count() > 0)
            return;

        Stream.of("HR", "Tech", "Finance", "Develop")
                .map(DepartamentEntity::new)
                .forEach(departDAO::save);
    }
}
