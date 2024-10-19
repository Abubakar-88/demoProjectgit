package com.demol.controller;

import com.demol.dto.product.ProductRequestDto;
import com.demol.dto.product.ProductResponseDto;
import com.demol.services.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/product")
public class Product {
    @Autowired
    ProductService productService;
    @PostMapping("/addProd")
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestPart("file")MultipartFile file,
                                                          @RequestPart("product") ProductRequestDto productRequestDto) throws IOException {
       ProductResponseDto responseDto = productService.addProduct(productRequestDto,file);
       return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
