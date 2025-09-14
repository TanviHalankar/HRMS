package com.hrms.employee_service.repository;
import com.hrms.employee_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
