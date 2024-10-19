package com.demol.services.serviceImpl.prodServimpl;

import com.demol.dto.product.ProductRequestDto;
import com.demol.dto.product.ProductResponseDto;
import com.demol.entity.Product;
import com.demol.repository.productrepository.ProductRepository;
import com.demol.services.service.productService.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class ProductServiceImpl implements ProductService {
    @Value("${image.upload.dir}")
    private String uploadDir;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto, MultipartFile multipartFile) throws IOException {
        Product product = modelMapper.map(productRequestDto, Product.class);
        if(!multipartFile.isEmpty()){
           String image =  saveImage(multipartFile,product);
            product.setImage(image);
        }
       Product saveProduct =  productRepository.save(product);
        return modelMapper.map(saveProduct, ProductResponseDto.class);

    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return  modelMapper.map(product, ProductResponseDto.class);

    }

    public String saveImage(MultipartFile file, Product product) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/product");
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        String fileName = product.getName()+"_"+ UUID.randomUUID();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(),filePath);
        return fileName;
    }

}
