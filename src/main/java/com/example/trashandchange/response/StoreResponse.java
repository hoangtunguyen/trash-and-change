package com.example.trashandchange.response;

import com.example.trashandchange.model.ProductModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreResponse {
    Integer id;
    String name;
    String address;
    String description;
    List<String> hashtagList;
    String imageUrl;
    double lat;
    double lng;
    List<ProductResponse> productResponseList;
}
