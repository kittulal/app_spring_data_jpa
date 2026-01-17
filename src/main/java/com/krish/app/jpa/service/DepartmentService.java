package com.krish.app.jpa.service;

import com.krish.app.jpa.dto.DepartmentResponseDto;
import com.krish.app.jpa.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepo;

    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentRepo.findAll().stream()
                .map(d -> new DepartmentResponseDto(
                        d.getId(),
                        d.getCode(),
                        d.getName(),
                        d.getLocation(),
                        d.isActive()
                ))
                .toList();
    }
}
