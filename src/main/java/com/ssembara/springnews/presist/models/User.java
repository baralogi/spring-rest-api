package com.ssembara.springnews.presist.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    // @OneToMany(mappedBy = "user")
    // private Set<Article> articles;

}
