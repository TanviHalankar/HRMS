package com.hrms.attendance_service.controller;


import com.hrms.attendance_service.entity.Attendance;
import com.hrms.attendance_service.entity.EmployeeDTO;
import com.hrms.attendance_service.service.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@Tag(name = "Attendance Management", description = "APIs for managing employee attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping
    @Operation(summary = "Create attendance record", description = "Create a new attendance record for an employee")
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return service.saveAttendance(attendance);
    }

    @GetMapping("/call-employee-service")
    @Operation(summary = "Test employee service connection", description = "Test the connection to employee service")
    public String callEmp() {
        return service.getEmployeeHello();
    }
    
    @GetMapping("/employee/{empId}")
    @Operation(summary = "Get employee details", description = "Retrieve employee details by ID from employee service")
    public EmployeeDTO getEmployee(@Parameter(description = "Employee ID") @PathVariable Long empId) {
        return service.getEmployeeById(empId);
    }

    @GetMapping("/{empId}")
    @Operation(summary = "Get attendance by employee ID", description = "Retrieve all attendance records for a specific employee")
    public List<Attendance> getAttendance(@Parameter(description = "Employee ID") @PathVariable Long empId) {
        return service.getAttendanceByEmpId(empId);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update attendance record", description = "Update an existing attendance record")
    public Attendance updateAttendance(@Parameter(description = "Attendance ID") @PathVariable Long id, @RequestBody Attendance attendance) {
        attendance.setId(id);  // ensure ID is set
        return service.updateAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete attendance record", description = "Delete an attendance record by ID")
    public void deleteAttendance(@Parameter(description = "Attendance ID") @PathVariable Long id) {
        service.deleteAttendance(id);
    }
//    @GetMapping("/emp/{empId}")
//    public AttendanceResponse getAttendanceByEmpId(@PathVariable Long empId) {
//        return service.getAttendanceByEmpId(empId);
//    }
}
