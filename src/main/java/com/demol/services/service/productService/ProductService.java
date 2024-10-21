package com.demol.services.service.productService;

import com.demol.dto.product.ProductRequestDto;
import com.demol.dto.product.ProductResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto, MultipartFile multipartFile) throws IOException;
    public ProductResponseDto getProductById(Long id);
    public List<ProductResponseDto> getAllProduct();
    public ProductResponseDto updateProduct(ProductRequestDto prodReqDto, Long id, MultipartFile mFile) throws IOException;
    public void deleteProduct(Long id);
}

