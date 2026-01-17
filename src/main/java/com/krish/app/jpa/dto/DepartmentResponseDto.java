package com.krish.app.jpa.dto;

public record DepartmentResponseDto(
        Long id,
        String code,
        String name,
        String location,
        boolean active
) {}
