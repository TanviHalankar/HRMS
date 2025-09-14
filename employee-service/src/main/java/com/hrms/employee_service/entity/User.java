package com.hrms.employee_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String fName;
    private String lName;
    private String designation;
    private double baseSal;
    private String joiningDate;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    // Getters & Setters
    public Long getEmpId() { return empId; }
    public void setEmpId(Long empId) { this.empId = empId; }

    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }

    public String getlName() { return lName; }
    public void setlName(String lName) { this.lName = lName; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getBaseSal() { return baseSal; }
    public void setBaseSal(double baseSal) { this.baseSal = baseSal; }

    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }

    public Dept getDept() { return dept; }
    public void setDept(Dept dept) { this.dept = dept; }
}
