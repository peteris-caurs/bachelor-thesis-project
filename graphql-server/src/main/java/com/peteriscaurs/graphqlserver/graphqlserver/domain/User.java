package com.peteriscaurs.graphqlserver.graphqlserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peteris-caurs
 */
@Document(collection = "users")
public class User {

    @Id private String id;
    private String name;
    private String email;
    private String password;
    @DBRef private List<Word> favorites = new ArrayList<>();

    public User() { }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Word> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Word> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", favorites=" + favorites +
                '}';
    }

}
