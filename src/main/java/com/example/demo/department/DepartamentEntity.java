package com.example.demo.department;

import com.example.demo.employee.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tblDepartments", uniqueConstraints = {
        @UniqueConstraint(columnNames = "dpID")
})
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class DepartamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpID", unique = true, nullable = false)
    private int dpID;

    @Column(name = "dpName", nullable = false)
    private String dpName;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "empID")
    private Set<EmployeeEntity> employeeEntitySet;

    public DepartamentEntity(String dpName) {
        this.dpName = dpName;
    }
}
