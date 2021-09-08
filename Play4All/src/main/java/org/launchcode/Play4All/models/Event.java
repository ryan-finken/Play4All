package org.launchcode.Play4All.models;

//import org.apache.tomcat.jni.Time;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Event extends AbstractEntity{


    private String name;

    private String description;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;



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

   // @Override
  // public String toString(){
   //     return name;
   // }
}
