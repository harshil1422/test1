package com.example.demo1.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Lob
    private byte[] image;
}
