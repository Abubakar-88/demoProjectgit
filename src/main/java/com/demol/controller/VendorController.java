package com.demol.controller;

import com.demol.dto.vendor.VendorRequestDTO;
import com.demol.dto.vendor.VendorResponseDTO;
import com.demol.services.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/register")
    public ResponseEntity<VendorResponseDTO> register(@RequestBody VendorRequestDTO vendorRequestDTO) {

        VendorResponseDTO vendorResponseDTO = vendorService.registerVendor(vendorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendorResponseDTO);
    }


}
