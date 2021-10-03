package org.launchcode.Play4All.models;


import javax.persistence.Entity;

@Entity
public class Venue extends AbstractEntity{

    private String name;

    private String description;

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

    @Override
    public String toString() {
        return name;
    }
}
