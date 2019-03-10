DROP TABLE IF EXISTS tblEmployees;
DROP TABLE IF EXISTS tblDepartments;

CREATE TABLE tblDepartments
(
dpID INTEGER PRIMARY KEY AUTO_INCREMENT,
dpName varchar(255) NOT NULL
);

CREATE TABLE tblEmployees
(
  empID INTEGER PRIMARY KEY AUTO_INCREMENT,
  empActive BIT NOT NULL,
  empName VARCHAR (255) NOT NULL,
  emp_dpID INTEGER NOT NULL,
  FOREIGN KEY (emp_dpID)
        REFERENCES tblDepartments(dpID)
);

