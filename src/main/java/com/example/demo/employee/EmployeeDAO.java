package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Integer> {

    EmployeeEntity findByEmpName(String empName);
    EmployeeEntity findByEmpID(Integer empId);

}
