package com.krish.app.jpa.repository;

import com.krish.app.jpa.dto.EmployeeFilterRequest;
import com.krish.app.jpa.entity.Department;
import com.krish.app.jpa.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findEmployeesByDynamicFilters(EmployeeFilterRequest filter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);
        Join<Employee, Department> department = employee.join("department", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        // employee.firstName
        if (filter.getFirstName() != null && !filter.getFirstName().isEmpty()) {
            predicates.add(
                    cb.like(
                            cb.lower(employee.get("firstName")),
                            "%" + filter.getFirstName().toLowerCase() + "%"
                    )
            );
        }

        // employee.lastName
        if (filter.getLastName() != null && !filter.getLastName().isEmpty()) {
            predicates.add(
                    cb.like(
                            cb.lower(employee.get("lastName")),
                            "%" + filter.getLastName().toLowerCase() + "%"
                    )
            );
        }

        // employee.email
        if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
            predicates.add(
                    cb.like(
                            cb.lower(employee.get("email")),
                            "%" + filter.getEmail().toLowerCase() + "%"
                    )
            );
        }

        // employee.status
        if (filter.getStatus() != null && !filter.getStatus().isEmpty()) {
            predicates.add(
                    cb.equal(employee.get("status"), filter.getStatus())
            );
        }

        // department.name
        if (filter.getDepartmentName() != null && !filter.getDepartmentName().isEmpty()) {
            predicates.add(
                    cb.like(
                            cb.lower(department.get("name")),
                            "%" + filter.getDepartmentName().toLowerCase() + "%"
                    )
            );
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));
        cq.orderBy(cb.asc(employee.get("firstName")));
        return entityManager.createQuery(cq).getResultList();
    }
}
