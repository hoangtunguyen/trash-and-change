package com.example.trashandchange.repository;

import com.example.trashandchange.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<ProductModel, Integer> {

    List<ProductModel> findAllByStoreModelId(Integer id);


}
