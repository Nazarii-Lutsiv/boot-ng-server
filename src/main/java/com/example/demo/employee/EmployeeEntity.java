package com.example.demo.employee;

import com.example.demo.department.DepartamentEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblEmployees", uniqueConstraints = {
        @UniqueConstraint(columnNames = "empID")
})
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empID", unique = true, nullable = false)
    private Integer empID;

    @Column(name = "empName", nullable = false)
    private String empName;

    @Column(name = "empActive")
    private boolean empActive;

    @ManyToOne
    private DepartamentEntity departamentEntity;

}
