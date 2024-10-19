package com.demol.services.serviceImpl;

import com.demol.dto.vendor.VendorRequestDTO;
import com.demol.dto.vendor.VendorResponseDTO;
import com.demol.entity.Vendor;
import com.demol.repository.VendorRepository;
import com.demol.services.service.VendorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    ModelMapper modelmapper;
    @Autowired
    VendorRepository vendorRepository;
    @Override
    public VendorResponseDTO registerVendor(VendorRequestDTO vendorRequestDTO) {
    Vendor vendor = modelmapper.map(vendorRequestDTO,Vendor.class);
     Vendor saveVendor =vendorRepository.save(vendor);
        return modelmapper.map(saveVendor, VendorResponseDTO.class);
    }
}
