package com.example.trashandchange.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "description")
    String description;

    @Column(name = "hashTag")
    String hashTag;

    @Column(name = "image")
    String image;

    @Column(name = "lat")
    String lat;

    @Column(name = "lng")
    String lng;

    @OneToMany(mappedBy = "storeModel")
    List<ProductModel> productModels;

}
