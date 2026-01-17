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

        List<Predicate> predicates = new ArrayList<>();

        // employee.firstName
        if (hasText(filter.getFirstName())) {
            predicates.add(
                    cb.equal(
                            cb.lower(employee.get("firstName")),
                            filter.getFirstName().toLowerCase()
                    )
            );
        }

        // employee.lastName
        if (hasText(filter.getLastName())) {
            predicates.add(
                    cb.like(
                            cb.lower(employee.get("lastName")),
                            "%" + filter.getLastName().toLowerCase() + "%"
                    )
            );
        }

        // employee.email
        if (hasText(filter.getEmail())) {
            predicates.add(
                    cb.equal(
                            cb.lower(employee.get("email")),
                            filter.getEmail().toLowerCase()
                    )
            );
        }

        // employee.status
        if (hasText(filter.getStatus())) {
            predicates.add(
                    cb.equal(employee.get("status"), filter.getStatus())
            );
        }

        // ✅ JOIN ONLY WHEN REQUIRED
        if (hasText(filter.getDepartmentName())) {
            Join<Employee, Department> department =
                    employee.join("department", JoinType.INNER);

            predicates.add(
                    cb.like(
                            cb.lower(department.get("name")),
                            "%" + filter.getDepartmentName().toLowerCase() + "%"
                    )
            );
        }

        cq.select(employee)
                .distinct(true) // ⭐ VERY IMPORTANT
                .where(cb.and(predicates.toArray(new Predicate[0])))
                .orderBy(cb.asc(employee.get("firstName")));

        return entityManager.createQuery(cq).getResultList();
    }

    private boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
