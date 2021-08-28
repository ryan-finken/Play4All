package org.launchcode.Play4All.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venue extends AbstractEntity{

    private String name;

    private String description;

    //@OneToMany
    //private List<Event> event = new ArrayList<>();

    public Venue(){}

    public Venue(String name, String description){
        this.name = name;
        this.description = description;
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

    //public List<Event> getEvents() {
    //    return event;
    //}
    //public void addEvent(Event event){
     //   this.event.add(event);
   // }
    @Override
    public String toString() {
        return name;
    }
}
