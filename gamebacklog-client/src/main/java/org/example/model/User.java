package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class User {

    private int id;
    private String username;
    private String password;
    private Set<Authority> authorities = new HashSet<>();

}
