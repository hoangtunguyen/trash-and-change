package com.example.trashandchange.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "adddress")
    String address;

    @Column(name = "currentAddress")
    String currentAddress;

    @Column(name = "trashSeed")
    Integer trashSeed;

    @Column(name = "historySearch")
    String histTorySearch;
}
