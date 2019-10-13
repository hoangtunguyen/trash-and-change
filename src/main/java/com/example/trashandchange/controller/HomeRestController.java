package com.example.trashandchange.controller;

import com.example.trashandchange.convert.ProductConvert;
import com.example.trashandchange.convert.StoreConvert;
import com.example.trashandchange.model.ProductModel;
import com.example.trashandchange.model.StoreModel;
import com.example.trashandchange.model.UserModel;
import com.example.trashandchange.response.ProductResponse;
import com.example.trashandchange.response.StoreResponse;
import com.example.trashandchange.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeRestController {

    @Autowired
    private GeneralService generalService;

    @RequestMapping(value = "/getAllStores")
    public List<StoreResponse> getAll(){
        return generalService.getAllStores().stream().map(StoreConvert::convert).collect(Collectors.toList());
    }

//    http://localhost:8080/getDetailStore?id=1
    @RequestMapping(value = "/getDetailStore")
    public StoreResponse getOne(@RequestParam(value="id", required=true) int id){
        StoreResponse storeResponse = new StoreResponse();
        storeResponse = StoreConvert.convert(generalService.getStoreById(id));
        return storeResponse;
    }

    @RequestMapping(value = "/getInforProduct")
    public ProductResponse findProduct(@RequestParam(value="id") int id){
        ProductResponse productResponse = ProductConvert.convert(generalService.findProductByID(id));
        return productResponse;
    }

    @RequestMapping(value = "/searchAllRest")
    public List<StoreResponse> findStore(@RequestParam(value="search", required=true) String search){

        return generalService.searchStores(search).stream().map(StoreConvert::convert).collect(Collectors.toList());
    }

    @PostMapping("/payProduct")
    public void payProduct(@Valid @RequestBody Integer seed,@RequestParam(value = "id") int id){
        UserModel userModel = generalService.getUserById(id);
        int contributed = userModel.getContributedSeed()+ seed;
        userModel.setContributedSeed(contributed);
        generalService.saveUser(userModel);
    }

}
