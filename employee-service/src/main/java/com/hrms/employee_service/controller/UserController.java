package com.hrms.employee_service.controller;


import com.hrms.employee_service.entity.User;
import com.hrms.employee_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee Management", description = "APIs for managing employees")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all employees", description = "Retrieve all employees from the system")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID", description = "Retrieve a specific employee by their ID")
    public User getUserById(@Parameter(description = "Employee ID") @PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/hello")
    @Operation(summary = "Health check", description = "Simple health check endpoint")
    public String hello(){
        return "Hello from emp-service";
    }

    @PostMapping
    @Operation(summary = "Create new employee", description = "Create a new employee record")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update employee", description = "Update an existing employee record")
    public User updateUser(@Parameter(description = "Employee ID") @PathVariable Long id, @RequestBody User user) {
        user.setEmpId(id);  // ensure the ID is set
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete employee", description = "Delete an employee by ID")
    public void deleteUser(@Parameter(description = "Employee ID") @PathVariable Long id) {
        userService.deleteUser(id);
    }
}
