package com.krish.app.jpa.repository;

import com.krish.app.jpa.dto.EmployeeFilterRequest;
import com.krish.app.jpa.entity.Employee;

import java.util.List;

public interface EmployeeRepositoryCustom {
    List<Employee> findEmployeesByDynamicFilters(EmployeeFilterRequest filter);
}