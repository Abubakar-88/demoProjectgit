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
import java.util.List;
import java.util.UUID;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

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

    @Override
    public List<ProductResponseDto> getAllProduct() {
      List<Product>  productList = productRepository.findAll();
      return productList.stream().map(product -> modelMapper.map(product,ProductResponseDto.class)).toList();

    }

    @Override
    public ProductResponseDto updateProduct(ProductRequestDto prodReqDto, Long id, MultipartFile mFile) throws IOException {
        //find existing product
        Product existingProd = productRepository.findById(id).orElse(null);
        //change existingProd by prodReqDto
        modelMapper.map(prodReqDto, existingProd);
        //set image
        if(!mFile.isEmpty()){
           String fileName = saveImage(mFile,existingProd);
           existingProd.setImage(fileName);
        }
        //save existingProd in data base
        Product updatedProd = productRepository.save(existingProd);
        //convert updateProd to ProductResponseDto and return
       return modelMapper.map(updatedProd,ProductResponseDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        // find existing product
        Product existingProd = productRepository.findById(id).orElse(null);
        //then delete existing product
        productRepository.delete(existingProd);

    }

    public String saveImage(MultipartFile file, Product product) throws IOException {
        //get() converts a string into a path object
        Path uploadPath = Paths.get(uploadDir + "/product");
        //check directory
        if(!Files.exists(uploadPath)){
            //create directory
            Files.createDirectories(uploadPath);
        }
        //give a name of directory
        String fileName = product.getName()+"_"+ UUID.randomUUID();
        //resolve() create full path by combining uploadPath and fileName
        Path filePath = uploadPath.resolve(fileName);
        //copy this path
        Files.copy(file.getInputStream(),filePath);
        //return file name
        return fileName;
    }

}
