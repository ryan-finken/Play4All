package org.launchcode.Play4All.models;

//import org.apache.tomcat.jni.Time;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Event extends AbstractEntity{


    private String name;

    private String description;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @DateTimeFormat(pattern = "h:mm a")
    private LocalTime time;

    @ManyToMany//(mappedBy = "event")
    private List<User> userList = new ArrayList<>();



    public Event(){ }

    public Event(String name, String description, String email, Date date, LocalTime time){
        this.name=name;
        this.description = description;
        this.email = email;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user){
        this.userList.add(user);
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    // @Override
  // public String toString(){
   //     return name;
   // }
}
