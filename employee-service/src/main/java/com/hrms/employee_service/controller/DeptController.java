package com.hrms.employee_service.controller;

import com.hrms.employee_service.entity.Dept;
import com.hrms.employee_service.service.DeptService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public List<Dept> getAllDepartments() {
        return deptService.getAllDepts();
    }

    @GetMapping("/{id}")
    public Dept getDepartmentById(@PathVariable Long id) {
        return deptService.getDeptById(id);
    }

    @PostMapping
    public Dept addDepartment(@RequestBody Dept dept) {
        return deptService.saveDept(dept);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        deptService.deleteDept(id);
    }
}

