package com.example.demo.department;


import com.example.demo.employee.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/departament")
@RequiredArgsConstructor
public class DepartController {

    private final DepartDAO departDAO;

    @GetMapping("/all")
    public Collection<DepartamentEntity> findAll(){
       return departDAO.findAll();
    }

    @GetMapping("/one")
    private DepartamentEntity findOneByName(Integer depId) {
        return departDAO.findByDpID(depId);
    }
}
