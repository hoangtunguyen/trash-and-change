package com.example.trashandchange.repository;

import com.example.trashandchange.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<UserModel,Integer> {
//    UserModel findById(int id);
}
