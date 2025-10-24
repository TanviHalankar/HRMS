package com.hrms.payroll.controller;

import com.hrms.payroll.entity.Payroll;
import com.hrms.payroll.service.PayrollService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
@Tag(name = "Payroll Management", description = "APIs for managing employee payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping
    @Operation(summary = "Get all payroll records", description = "Retrieve all payroll records from the system")
    public List<Payroll> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get payroll by ID", description = "Retrieve a specific payroll record by its ID")
    public Payroll getPayrollById(@Parameter(description = "Payroll ID") @PathVariable Long id) {
        return payrollService.getPayrollById(id);
    }

    @GetMapping("/employee/{empId}")
    @Operation(summary = "Get payroll by employee ID", description = "Retrieve payroll records for a specific employee")
    public List<Payroll> getPayrollByEmployeeId(@Parameter(description = "Employee ID") @PathVariable Long empId) {
        return payrollService.getPayrollByEmployeeId(empId);
    }

    @PostMapping
    @Operation(summary = "Create new payroll record", description = "Create a new payroll record for an employee")
    public Payroll createPayroll(@RequestBody Payroll payroll) {
        return payrollService.savePayroll(payroll);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update payroll record", description = "Update an existing payroll record")
    public Payroll updatePayroll(@Parameter(description = "Payroll ID") @PathVariable Long id, @RequestBody Payroll payroll) {
        payroll.setId(id);
        return payrollService.updatePayroll(payroll);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete payroll record", description = "Delete a payroll record by ID")
    public void deletePayroll(@Parameter(description = "Payroll ID") @PathVariable Long id) {
        payrollService.deletePayroll(id);
    }

    @GetMapping("/hello")
    @Operation(summary = "Health check", description = "Simple health check endpoint")
    public String hello() {
        return "Hello from payroll service";
    }
}
