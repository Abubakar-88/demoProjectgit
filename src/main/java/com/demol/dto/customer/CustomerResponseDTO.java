package com.demol.dto.customer;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerResponseDTO {
    private Long id;
    private String name;
    private Long phone;

}
