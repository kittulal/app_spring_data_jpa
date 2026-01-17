package com.krish.app.jpa.controller;

import com.krish.app.jpa.dto.EmployeeCreateRequest;
import com.krish.app.jpa.dto.EmployeeFilterRequest;
import com.krish.app.jpa.dto.EmployeeResponseDto;
import com.krish.app.jpa.entity.Employee;
import com.krish.app.jpa.service.EmployeeService;
import com.krish.app.jpa.utils.EmployeeMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // ✅ SAVE EMPLOYEE
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @Valid @RequestBody EmployeeCreateRequest request) {

        EmployeeResponseDto response = service.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<EmployeeResponseDto> listAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/department/{code}")
    public List<EmployeeResponseDto> employeesByDepartment(@PathVariable String code) {
        return service.getEmployeesByDepartment(code);
    }

    @PutMapping("/{empId}/department/{deptId}")
    public ResponseEntity<Void> transferEmployee(
            @PathVariable Long empId,
            @PathVariable Long deptId) {
        service.transferEmployee(empId, deptId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public List<EmployeeResponseDto> searchEmployees(
            @RequestBody EmployeeFilterRequest filter) {
        return service.getEmployeesByFilters(filter);
    }
}
