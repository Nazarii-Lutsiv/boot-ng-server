package com.example.demo.department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartDAO extends JpaRepository<DepartamentEntity, Integer> {
    public DepartamentEntity findByDpID(Integer empId);
}
