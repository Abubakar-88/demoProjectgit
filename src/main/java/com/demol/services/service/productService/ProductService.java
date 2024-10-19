package com.demol.services.service.productService;

import com.demol.dto.product.ProductRequestDto;
import com.demol.dto.product.ProductResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto, MultipartFile multipartFile) throws IOException;
    public ProductResponseDto getProductById(Long id);
}

