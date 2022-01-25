package com.nugrohosamiyono.studyjam.presist.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "user")
@Table(name = "user")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private int age;
}
