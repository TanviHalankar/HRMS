package com.hrms.employee_service.service;


import com.hrms.employee_service.entity.Dept;
import com.hrms.employee_service.repository.DeptRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeptService {

    private final DeptRepository deptRepository;

    public DeptService(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    public List<Dept> getAllDepts() {
        return deptRepository.findAll();
    }

    public Dept getDeptById(Long id) {
        return deptRepository.findById(id).orElse(null);
    }

    public Dept saveDept(Dept dept) {
        return deptRepository.save(dept);
    }

    public void deleteDept(Long id) {
        deptRepository.deleteById(id);
    }
}
