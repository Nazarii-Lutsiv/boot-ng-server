package com.example.demo.employee;

import com.example.demo.department.DepartDAO;
import com.example.demo.department.DepartamentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeDAO employeeDAO;
    private final DepartDAO departDAO;

    @GetMapping("/all")
    private Collection<EmployeeEntity> findAll() {
        return employeeDAO.findAll();
    }

    @GetMapping("/{empID}")
    private EmployeeEntity findOneById(@PathVariable(value = "empID") Integer empId) {
        return employeeDAO.findByEmpID(empId);
    }


    @GetMapping("/")
    private EmployeeEntity findOneByName(String empName) {
        return employeeDAO.findByEmpName(empName);
    }

    @DeleteMapping("/delete/{empID}")
    private ResponseEntity<?> delete(@PathVariable(value = "empID") Integer empId){
        EmployeeEntity empEntity = employeeDAO.findByEmpID(empId);
        if(empEntity == null){
            return ResponseEntity.notFound().build();
        }
        employeeDAO.delete(empEntity);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{empID}")
    private ResponseEntity<?> update(
            @PathVariable(value = "empID") Integer empId,
            @Valid @RequestBody EmployeeEntity empDetails
    ){
        EmployeeEntity employee = employeeDAO.findByEmpID(empId);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        employee.setEmpName(empDetails.getEmpName());
        employee.setEmpActive(empDetails.isEmpActive());
        employee.setDepartamentEntity(empDetails.getDepartamentEntity());
        EmployeeEntity editEmployee = employeeDAO.save(employee);

        return ResponseEntity.ok(editEmployee);
    }

    @PostMapping("/create")
    public EmployeeEntity create(@Valid @RequestBody EmployeeEntity emp){
        return employeeDAO.save(emp);
    }

}
