package com.bassettmason.codefellowship;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    String userName;
    String password;
    String firstName;
    String lastName;
    String dateOfBirth;
    String picture;
    String bio;

    public ApplicationUser() {}

    public ApplicationUser(String userName, String password, String firstName, String lastName, String dateOfBirth, String picture, String bio) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.picture = picture;
        this.bio = bio;
    }
    @Override
    public String toString() {return userName + firstName + lastName + dateOfBirth + picture + bio;}
}
