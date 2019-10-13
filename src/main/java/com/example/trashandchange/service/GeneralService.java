package com.example.trashandchange.service;

import com.example.trashandchange.model.ProductModel;
import com.example.trashandchange.model.StoreModel;
import com.example.trashandchange.model.UserModel;
import com.example.trashandchange.repository.ProductRepository;
import com.example.trashandchange.repository.StoreRepository;
import com.example.trashandchange.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRespository userRespository;

    public StoreModel getStoreById(int id){
        return storeRepository.findById(id).get();
    }

    public List<StoreModel> getAllStores(){
        return storeRepository.getAllStores();

    }
    public UserModel getUserById(int id){
        return userRespository.findById(id).get();
    }

    public List<StoreModel> searchStores(String search){
        return storeRepository.findAllByNameContainingOrAddressContainingOrHashTagContaining(search,search,search);
    }

    public ProductModel findProductByID(int id){
        return productRepository.findById(id).get();
    }

    public void saveProduct(ProductModel productModel){
         productRepository.save(productModel);
    }
}
