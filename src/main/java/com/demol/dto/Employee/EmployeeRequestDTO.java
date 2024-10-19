package com.demol.dto.Employee;

import lombok.Data;

@Data
public class EmployeeRequestDTO {
    private  String name;
    private String email;
    private String password;
}
