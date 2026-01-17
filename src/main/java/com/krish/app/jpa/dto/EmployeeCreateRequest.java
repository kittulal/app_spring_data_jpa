package com.krish.app.jpa.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record EmployeeCreateRequest(

        @NotBlank
        String empCode,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @Email
        @NotBlank
        String email,

        @NotNull
        Double salary,

        @NotBlank
        String designation,

        @NotNull
        LocalDate joiningDate,

        @NotBlank
        String status,

        @NotNull
        Long departmentId
) {}
