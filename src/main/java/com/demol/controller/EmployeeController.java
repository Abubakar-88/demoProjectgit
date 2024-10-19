package com.demol.controller;

import com.demol.dto.Employee.EmployeeRequestDTO;
import com.demol.dto.Employee.EmployeeResponseDTO;
import com.demol.services.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> saveProduct
            ( @RequestBody  EmployeeRequestDTO employeeRequestDTO) {

        EmployeeResponseDTO responseDTO = employeeService.createEmployee(employeeRequestDTO);

       System.out.println("Saving");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
