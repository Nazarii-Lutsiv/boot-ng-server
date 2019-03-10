package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Integer> {

    public EmployeeEntity findByEmpName(String empName);
    public EmployeeEntity findByEmpID(Integer empId);
}
