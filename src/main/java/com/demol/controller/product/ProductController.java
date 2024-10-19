package com.demol.controller.product;

import com.demol.dto.product.ProductRequestDto;
import com.demol.dto.product.ProductResponseDto;
import com.demol.services.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/saveProd")
    public ResponseEntity<ProductResponseDto > addProduct(@RequestPart("file")MultipartFile multipartFile,
                                         @RequestPart("product")ProductRequestDto productRequestDto) throws IOException {
       ProductResponseDto responseDto = productService.addProduct(productRequestDto,multipartFile);
       return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
