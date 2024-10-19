package com.demol.dto.Employee;

import lombok.Data;

@Data

public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
}
