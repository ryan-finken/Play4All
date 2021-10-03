package org.launchcode.Play4All.Controllers;


import org.launchcode.Play4All.data.EventRepository;
import org.launchcode.Play4All.data.UserRepository;
import org.launchcode.Play4All.models.Event;
import org.launchcode.Play4All.models.User;
import org.launchcode.Play4All.models.dto.UserEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String displayEvents(@RequestParam(required = false) Integer eventId, Model model) {

        if (eventId == null) {
            model.addAttribute("title", "All Events");
            model.addAttribute("event", eventRepository.findAll());
        } else {
            Optional<Event> result = eventRepository.findById(eventId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Category ID: " + eventId);
            } else {
                Event event = result.get();
                model.addAttribute("title", "Event in Venue: " + event.getName());
                model.addAttribute("event", event.getDescription());
            }
        }

        return "event/index";
    }


    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "event/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "event/create";
        }

        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping("details")
    public String displayUserDetails(@RequestParam Integer eventId, Model model) {
        Optional<Event> result = eventRepository.findById(eventId);
        Event event = result.get();
        model.addAttribute("event", event);

        return "event/details";
    }
    @GetMapping("edit-event")
    public String displayEditBioForm(@RequestParam Integer eventId, Model model) {
        Optional<Event> result = eventRepository.findById(eventId);
        Event event = result.get();
        model.addAttribute("event", event);

        return "event/edit-event";

    }

    @PostMapping("edit-event")
    public String processEditBioForm(@RequestParam int id, @RequestParam String description) {

        Optional<Event> result = eventRepository.findById(id);
        Event event = result.get();
        event.setDescription(description);
        eventRepository.save(event);

        return "redirect:details?eventId=" + id;
    }

    @GetMapping("register")
    public String displayRegisterForm(@RequestParam Integer eventId, @RequestParam Integer userId){
        Optional<Event> eventResult = eventRepository.findById(eventId);
        Event event = eventResult.get();
        Optional<User> userResult = userRepository.findById(userId);
        User user = userResult.get();
        if (!event.getUsers().contains(user)) {
            event.addUser(user);
            eventRepository.save(event);
        }

        return "redirect:details?eventId=" + eventId;
    }

}
