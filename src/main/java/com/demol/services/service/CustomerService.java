package com.demol.services.service;

import com.demol.dto.customer.CustomerRequestDTO;
import com.demol.dto.customer.CustomerResponseDTO;
import com.demol.entity.Customer;

import java.util.List;

public interface CustomerService {

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

     public CustomerResponseDTO getByIdCustomer(long id);

    public List<CustomerResponseDTO> getAllCustomer ();

    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO ,Long id);

    public  void deletCustomer (Long id);


}
