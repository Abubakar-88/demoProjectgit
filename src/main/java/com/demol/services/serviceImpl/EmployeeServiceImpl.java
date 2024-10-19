package com.demol.services.serviceImpl;

import com.demol.dto.Employee.EmployeeRequestDTO;
import com.demol.dto.Employee.EmployeeResponseDTO;
import com.demol.entity.Employee;
import com.demol.repository.EmployeeRepository;
import com.demol.services.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {

        Employee employee = modelMapper.map(employeeRequestDTO, Employee.class);

      Employee saveEmployee=  employeeRepository.save(employee);

        return modelMapper.map(saveEmployee, EmployeeResponseDTO.class);
    }
}
