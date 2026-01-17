package com.krish.app.jpa.controller;

import com.krish.app.jpa.dto.DepartmentResponseDto;
import com.krish.app.jpa.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<DepartmentResponseDto> listDepartments() {
        return service.getAllDepartments();
    }
}
