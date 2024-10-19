package com.demol.services;

import com.demol.dto.customer.CustomerRequestDTO;
import com.demol.dto.customer.CustomerResponseDTO;
import com.demol.entity.Customer;
import com.demol.repository.CustomerRepository;
import com.demol.services.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
  private  CustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
       Customer customer= modelMapper.map(customerRequestDTO,Customer.class);
      Customer customer1= customerRepository.save(customer);
      CustomerResponseDTO customerResponseDTO =modelMapper.map(customer1,CustomerResponseDTO.class);

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getByIdCustomer(long id) {
     Customer  customer= customerRepository.findById(id).orElse(null);
   CustomerResponseDTO customerResponseDTO=  modelMapper.map(customer,CustomerResponseDTO.class);
        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomer() {
       List<Customer> customerList= customerRepository.findAll();
      return customerList.stream().map(customer -> modelMapper.map(customer,CustomerResponseDTO.class)).toList();

    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO,Long id) {
        Customer  existingCustomer= customerRepository.findById(id).orElse(null);
        modelMapper.map(customerRequestDTO,existingCustomer);
        Customer updatecustomer=customerRepository.save(existingCustomer);
       CustomerResponseDTO customerResponseDTO = modelMapper.map(updatecustomer,CustomerResponseDTO.class);

        return customerResponseDTO;
    }

    @Override
    public void deletCustomer(Long id) {
      Customer existingCustomer =  customerRepository.findById(id).orElse(null);
      customerRepository.delete(existingCustomer);
    //  customerRepository.findById(id);

    }
}
