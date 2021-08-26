package org.launchcode.Play4All.Controllers;

import jdk.jfr.Event;
import org.launchcode.Play4All.data.EventRepository;
import org.launchcode.Play4All.data.VenueRepository;
import org.launchcode.Play4All.models.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping
    public String displayEvents(@RequestParam(required = false) Integer eventId, Model model) {

        if (eventId == null) {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventRepository.findAll());
        } else {
            Optional<Event> result = eventRepository.findById(eventId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Category ID: " + eventId);
            } else {
                Event event = result.get();
                model.addAttribute("title", "Events in Venue: " + event.toString());
                model.addAttribute("events", eventRepository.save(event));
            }
        }

        return "events/index";
    }
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }
}
