package com.hrms.employee_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    private String dName;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users;

    // Getters & Setters
    public Long getDeptId() { return deptId; }
    public void setDeptId(Long deptId) { this.deptId = deptId; }

    public String getdName() { return dName; }
    public void setdName(String dName) { this.dName = dName; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
}
