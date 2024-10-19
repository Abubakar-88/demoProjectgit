package com.demol.controller;

import com.demol.dto.customer.CustomerRequestDTO;
import com.demol.dto.customer.CustomerResponseDTO;
import com.demol.services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        CustomerResponseDTO customerResponseDTO = customerService.createCustomer(customerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id) {
        CustomerResponseDTO customerResponseDTO = customerService.getByIdCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTO);
    }

    @GetMapping("/allCustomer")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        List<CustomerResponseDTO> customerResponseDTOList = customerService.getAllCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTOList);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO,@PathVariable Long id) {
        CustomerResponseDTO customerResponseDTO = customerService.updateCustomer(customerRequestDTO,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
          customerService.deletCustomer(id);
        return ResponseEntity.noContent().build();
    }
}