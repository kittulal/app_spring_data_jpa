package com.krish.app.jpa.service;

import com.krish.app.jpa.dto.EmployeeCreateRequest;
import com.krish.app.jpa.dto.EmployeeFilterRequest;
import com.krish.app.jpa.dto.EmployeeResponseDto;
import com.krish.app.jpa.entity.Department;
import com.krish.app.jpa.entity.Employee;
import com.krish.app.jpa.repository.DepartmentRepository;
import com.krish.app.jpa.repository.EmployeeRepository;
import com.krish.app.jpa.utils.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;

    public EmployeeService(EmployeeRepository employeeRepo,
                           DepartmentRepository departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }


    // ✅ CREATE EMPLOYEE
    public EmployeeResponseDto createEmployee(EmployeeCreateRequest request) {

        Department department = departmentRepo.findById(request.departmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        Employee employee = EmployeeMapper.mapToEntity(request);
        employee.setDepartment(department);

        Employee saved = employeeRepo.save(employee);

        return EmployeeMapper.mapToDto(saved);
    }

    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepo.findAll().stream()
                .map(EmployeeMapper::mapToDto)
                .toList();
    }

    public List<EmployeeResponseDto> getEmployeesByDepartment(String code) {
        return employeeRepo.findByDepartmentCode(code).stream()
                .map(EmployeeMapper::mapToDto)
                .toList();
    }

    public void transferEmployee(Long empId, Long deptId) {
        Employee emp = employeeRepo.findById(empId).orElseThrow();
        Department dept = departmentRepo.findById(deptId).orElseThrow();
        emp.setDepartment(dept);
    }

    public List<EmployeeResponseDto> getEmployeesByFilters(EmployeeFilterRequest filter) {
        List<Employee> employeeList = employeeRepo.findEmployeesByDynamicFilters(filter);
        return employeeList.stream()
                .map(EmployeeMapper::mapToDto)
                .toList();
    }


}
