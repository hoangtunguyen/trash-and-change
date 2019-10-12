package com.example.trashandchange.repository;

import com.example.trashandchange.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<StoreModel,Integer> {
    @Query("select r from #{#entityName} r")
    List<StoreModel> getAllStores();

    List<StoreModel> findAllByNameContainingOrAddressContainingOrHashTagContaining(String name, String address, String tag);
}
