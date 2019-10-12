package com.example.trashandchange.convert;

import com.example.trashandchange.model.ProductModel;
import com.example.trashandchange.response.ProductResponse;

import java.util.Arrays;

public class ProductConvert {
    public static ProductResponse convert(ProductModel productModel){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productModel.getId());
        productResponse.setName(productModel.getName());
        productResponse.setDescription(productModel.getDescription());
        productResponse.setQuantity(productModel.getQuantity());
        productResponse.setPrice(productModel.getPrice());
        productResponse.setGiftPercents(productModel.getGiftPercents());
        String[] list = productModel.getMainKeyWords().split(" ");
        productResponse.setMainKeywords(Arrays.asList(list));
        return productResponse;
    }
}
