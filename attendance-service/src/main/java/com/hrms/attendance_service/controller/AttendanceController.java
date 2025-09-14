package com.hrms.attendance_service.controller;


import com.hrms.attendance_service.entity.Attendance;
import com.hrms.attendance_service.entity.EmployeeDTO;
import com.hrms.attendance_service.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return service.saveAttendance(attendance);
    }

    @GetMapping("/call-employee-service")
    public String callEmp() {
        return service.getEmployeeHello();
    }
    @GetMapping("/employee/{empId}")
    public EmployeeDTO getEmployee(@PathVariable Long empId) {
        return service.getEmployeeById(empId);
    }

    @GetMapping("/{empId}")
    public List<Attendance> getAttendance(@PathVariable Long empId) {
        return service.getAttendanceByEmpId(empId);
    }
    // UPDATE attendance by ID
    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        attendance.setId(id);  // ensure ID is set
        return service.updateAttendance(attendance);
    }

    // DELETE attendance by ID
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        service.deleteAttendance(id);
    }
//    @GetMapping("/emp/{empId}")
//    public AttendanceResponse getAttendanceByEmpId(@PathVariable Long empId) {
//        return service.getAttendanceByEmpId(empId);
//    }
}
