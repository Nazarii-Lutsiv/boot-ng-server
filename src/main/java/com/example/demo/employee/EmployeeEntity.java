package com.example.demo.employee;

import com.example.demo.department.DepartamentEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblEmployees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empID")
    private Integer empID;
    @Column(name = "empName", nullable = false)
    private String empName;
    @Column(name = "empActive")
    private boolean empActive;
    @Column(name = "emp_dpID")
    private Integer emp_dpID;

}
