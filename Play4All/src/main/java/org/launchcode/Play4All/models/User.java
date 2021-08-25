package org.launchcode.Play4All.models;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity{
    @NotNull
    private String username;

    @Email
    private String email;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){}

    public User(String username, String email, String password){
        //this();
        this.username = username;
        this.email = email;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername(){
        return username;
    }


    public String getEmail(){ return email; }

    //public void setEmail(String email) {
    //    this.email = email;
   // }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password, pwHash);
    }
}
