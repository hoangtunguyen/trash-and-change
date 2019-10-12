package com.example.trashandchange.convert;

import com.example.trashandchange.model.ProductModel;
import com.example.trashandchange.model.StoreModel;
import com.example.trashandchange.response.ProductResponse;
import com.example.trashandchange.response.StoreResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConvert {
    public static final String BLANK = " ";
    public static StoreResponse convert(StoreModel storeModel){
            StoreResponse storeResponse = new StoreResponse();
            storeResponse.setId(storeModel.getId());
            storeResponse.setName(storeModel.getName());
            storeResponse.setAddress(storeModel.getAddress());
            storeResponse.setDescription(storeModel.getDescription());
            String[] hashTag = storeModel.getHashTag().split(StoreConvert.BLANK);
            storeResponse.setHashtagList(Arrays.asList(hashTag));
            storeResponse.setImageUrl(storeModel.getImage());
            storeResponse.setLat(Double.parseDouble(storeModel.getLat()));
            storeResponse.setLng(Double.parseDouble(storeModel.getLng()));
            storeResponse.setProductResponseList(storeModel.getProductModels().stream().map(ProductConvert::convert).collect(Collectors.toList()));
            return storeResponse;
    }

}
