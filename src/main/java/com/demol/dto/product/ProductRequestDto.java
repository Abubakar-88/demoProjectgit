package com.demol.dto.product;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductRequestDto {
  //  @Length(min=5, max=30, message="Name must be between 5 and 30 letter")
    @NotEmpty(message = "Name Can Not be Empty")
    private String name;
    @NotEmpty(message = "Price can not be empty")
    private String price;
    @NotEmpty(message = "Description can not be empty")
    @Length(min=10, max=150, message = "Description must be between 10 and 150 letter")
    private String description;
    private String image;
}
