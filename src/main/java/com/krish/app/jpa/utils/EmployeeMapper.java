package com.krish.app.jpa.utils;

import com.krish.app.jpa.dto.EmployeeCreateRequest;
import com.krish.app.jpa.dto.EmployeeResponseDto;
import com.krish.app.jpa.entity.Employee;
import org.springframework.stereotype.Service;


public class EmployeeMapper {

    public static Employee mapToEntity(EmployeeCreateRequest request) {
        Employee employee = new Employee();
        employee.setEmpCode(request.empCode());
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setEmail(request.email());
        employee.setSalary(request.salary());
        employee.setDesignation(request.designation());
        employee.setJoiningDate(request.joiningDate());
        employee.setStatus(request.status());
        return employee;
    }

    public static EmployeeResponseDto mapToDto(Employee e) {
        return new EmployeeResponseDto(
                e.getId(),
                e.getEmpCode(),
                e.getFirstName() + " " + e.getLastName(),
                e.getEmail(),
                e.getDesignation(),
                e.getSalary(),
                e.getStatus(),
                e.getDepartment().getCode()
        );
    }
}
