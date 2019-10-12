package com.example.trashandchange.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name ="price")
    Integer price;

    @Column(name = "giftPercents")
    Integer giftPercents;

    @Column(name = "mainKeyWords")
    String mainKeyWords;

    @Column(name = "soldQuantity")
    Integer soldQuantity;

    @ManyToOne
    @JoinColumn(name = "storeId")
    StoreModel storeModel;


}
