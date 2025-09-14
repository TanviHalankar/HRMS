package com.hrms.attendance_service.service;



import com.hrms.attendance_service.entity.Attendance;

import com.hrms.attendance_service.entity.EmployeeDTO;
import com.hrms.attendance_service.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Attendance saveAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    // Call Employee microservice
    public String getEmployeeHello() {
        // Replace with your employee service URL
        return restTemplate.getForObject("http://localhost:8081/employees/hello", String.class);
    }

    public List<Attendance> getAttendanceByEmpId(Long empId) {
        return repository.findByEmpId(empId);
    }
public EmployeeDTO getEmployeeById(Long empId) {
    String url = "http://localhost:8081/users/" + empId; // Employee service URL
    return restTemplate.getForObject(url, EmployeeDTO.class);
}

    // Update attendance
    public Attendance updateAttendance(Attendance attendance) {
        return repository.save(attendance); // save updates if ID exists
    }

    // Delete attendance
    public void deleteAttendance(Long id) {
        repository.deleteById(id);
    }



//    public AttendanceResponse getAttendanceByEmpId(Long empId) {
//        Attendance attendance = repository.findByEmpId(empId);
//
//        // Call Employee Service (assuming it runs on port 8081)
//        Employee employee = restTemplate.getForObject(
//                "http://localhost:8081/employees/" + empId,
//                Employee.class
//        );
//
//        String ename = employee.getFName() + " " + employee.getLName();
//
//        return new AttendanceResponse(
//                empId,
//                ename,
//                attendance.getPresentDays(),
//                attendance.getAbsentDays(),
//                attendance.getLeaveDays()
//        );
//    }
}
