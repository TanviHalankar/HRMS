package com.hrms.employee_service.repository;

import com.hrms.employee_service.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {
}
