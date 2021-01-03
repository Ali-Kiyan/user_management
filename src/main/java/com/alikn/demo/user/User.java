package com.alikn.demo.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private final UUID userId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;

    public UUID getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public User(@JsonProperty("userId") UUID userId,
                @JsonProperty("firstName")String firstName,
                @JsonProperty("lastName")String lastName,
                @JsonProperty("email")String email,
                @JsonProperty("gender")Gender gender) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    enum Gender {
     MALE, FEMALE
    }

}
