package com.mamoune.crudedacybackend.service;

import lombok.Data;

@Data
public class ProductDTO {
    private String label;
    private String price;
    private String quantity;
    private String desc;
}
