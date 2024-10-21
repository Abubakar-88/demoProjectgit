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
import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id){
        ProductResponseDto responseDto = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponseDto>> getAllProduct(){
        List<ProductResponseDto> responseDtos = productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(responseDtos);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDto> updateProductById(
            @RequestPart("product") ProductRequestDto prodreqDto,
            @PathVariable Long id,
            @RequestPart("file") MultipartFile multipartFile
    ) throws IOException {
       ProductResponseDto responseDto = productService.updateProduct(prodreqDto, id, multipartFile);
       //return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        return ResponseEntity.ok(responseDto);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity <Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
