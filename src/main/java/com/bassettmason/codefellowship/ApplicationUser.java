package com.bassettmason.codefellowship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    String userName;
    String password;
    String firstName;
    String lastName;
    Date dateOfBirth;
    String bio;

    public ApplicationUser() {}

    public ApplicationUser(String userName, String password, String firstName, String lastName, Date dateOfBirth, String bio) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }
    public String toString() {return userName + firstName + lastName + dateOfBirth + bio;}
}
