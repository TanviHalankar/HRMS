package com.hrms.payroll.service;

import com.hrms.payroll.entity.Payroll;
import com.hrms.payroll.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id).orElse(null);
    }

    public List<Payroll> getPayrollByEmployeeId(Long empId) {
        return payrollRepository.findByEmpId(empId);
    }

    public Payroll savePayroll(Payroll payroll) {
        payroll.setNetSalary(payroll.calculateNetSalary());
        return payrollRepository.save(payroll);
    }

    public Payroll updatePayroll(Payroll payroll) {
        payroll.setNetSalary(payroll.calculateNetSalary());
        return payrollRepository.save(payroll);
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
