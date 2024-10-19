package com.demol.services.service;

import com.demol.dto.vendor.VendorRequestDTO;
import com.demol.dto.vendor.VendorResponseDTO;

public interface VendorService {
    public VendorResponseDTO registerVendor(VendorRequestDTO vendorRequestDTO);
}
