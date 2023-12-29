package com.workager.lib.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Getter
public class User {
    @Id
    @Column(columnDefinition = "VARCHAR(36)",unique = true)
    private String userId;


}
