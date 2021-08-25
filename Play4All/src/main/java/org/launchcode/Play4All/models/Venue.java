package org.launchcode.Play4All.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venue extends AbstractEntity{

    private String name;

    private String description;

    @OneToMany
    private List<Events> events = new ArrayList<>();


}
