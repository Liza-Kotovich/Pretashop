package org.example.model;

import lombok.Data;

@Data
public class User {

    private String email;
    private String password;

    public User() {
    }
}
