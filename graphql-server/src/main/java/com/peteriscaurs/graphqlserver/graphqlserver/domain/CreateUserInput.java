package com.peteriscaurs.graphqlserver.graphqlserver.domain;

/**
 * @author peteris-caurs
 */
public class CreateUserInput {

    private String email;
    private String password;

    public CreateUserInput() { }

    public CreateUserInput(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "CreateUserInput{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
