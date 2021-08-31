package org.launchcode.Play4All.models;

<<<<<<< HEAD

=======
>>>>>>> event_controller
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

<<<<<<< HEAD
    public List<Events> getEvents() {
        return events;
    }

    public void addEvent(Events event){
        this.events.add(event);
    }
=======
    //public List<Event> getEvents() {
    //    return event;
    //}
    //public void addEvent(Event event){
     //   this.event.add(event);
   // }
>>>>>>> event_controller
    @Override
    public String toString() {
        return name;
    }
}
