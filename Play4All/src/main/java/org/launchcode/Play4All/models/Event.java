package org.launchcode.Play4All.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class Event extends AbstractEntity{

    @ManyToOne
    private Venue venue;

    private String name;

    private String description;

    public Event(){ }

    public Event(String name, String description, Venue venue){
        this.name=name;
        this.description = description;
        this.venue = venue;
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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public String toString(){
        return name;
    }
}
