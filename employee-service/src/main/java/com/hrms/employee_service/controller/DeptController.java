package com.hrms.employee_service.controller;

import com.hrms.employee_service.entity.Dept;
import com.hrms.employee_service.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
@Tag(name = "Department Management", description = "APIs for managing departments")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    @Operation(summary = "Get all departments", description = "Retrieve all departments from the system")
    public List<Dept> getAllDepartments() {
        return deptService.getAllDepts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get department by ID", description = "Retrieve a specific department by its ID")
    public Dept getDepartmentById(@Parameter(description = "Department ID") @PathVariable Long id) {
        return deptService.getDeptById(id);
    }

    @PostMapping
    @Operation(summary = "Create new department", description = "Create a new department record")
    public Dept addDepartment(@RequestBody Dept dept) {
        return deptService.saveDept(dept);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete department", description = "Delete a department by ID")
    public void deleteDepartment(@Parameter(description = "Department ID") @PathVariable Long id) {
        deptService.deleteDept(id);
    }
}

