package com.demol.services.service;

import com.demol.dto.Employee.EmployeeRequestDTO;
import com.demol.dto.Employee.EmployeeResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
}
