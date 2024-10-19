package com.demol.dto.vendor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorRequestDTO {
    private Long id;
    private String name;
    private String email;
    private String password;

}
