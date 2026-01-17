package com.krish.app.jpa.repository;

import com.krish.app.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom  {

    List<Employee> findByDepartmentCode(String code);

    Optional<Employee> findByEmail(String email);

    @Query("""
                select e from Employee e
                join fetch e.department
                where e.status = :status
            """)
    List<Employee> findActiveEmployees(@Param("status") String status);


    List<Employee> findByStatus(String status);
}
