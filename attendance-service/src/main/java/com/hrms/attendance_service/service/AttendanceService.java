package com.hrms.attendance_service.service;



import com.hrms.attendance_service.entity.Attendance;

import com.hrms.attendance_service.entity.EmployeeDTO;
import com.hrms.attendance_service.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    @Autowired
    private EmployeeClient employeeClient;

    public Attendance saveAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    // Call Employee microservice via Feign
    public String getEmployeeHello() {
        return employeeClient.hello();
    }

    public List<Attendance> getAttendanceByEmpId(Long empId) {
        return repository.findByEmpId(empId);
    }

    public EmployeeDTO getEmployeeById(Long empId) {
        return employeeClient.getEmployeeById(empId);
    }

    // Update attendance
    public Attendance updateAttendance(Attendance attendance) {
        return repository.save(attendance); // save updates if ID exists
    }

    // Delete attendance
    public void deleteAttendance(Long id) {
        repository.deleteById(id);
    }
}
