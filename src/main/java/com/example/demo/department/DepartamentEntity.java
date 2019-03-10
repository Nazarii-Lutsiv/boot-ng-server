package com.example.demo.department;

import com.example.demo.employee.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblDepartments")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

public class DepartamentEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpID")
    private int dpID;
    @Column(name = "dpName", nullable = false)
    private String dpName;



    public DepartamentEntity(String dpName) {
        this.dpName = dpName;
    }
}
