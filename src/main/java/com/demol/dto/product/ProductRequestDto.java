package com.demol.dto.product;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String price;
    private String description;
    private String image;
}
