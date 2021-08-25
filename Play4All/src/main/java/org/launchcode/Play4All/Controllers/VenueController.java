package org.launchcode.Play4All.Controllers;

import jdk.jfr.Event;
import org.launchcode.Play4All.data.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("venue")
public class VenueController {

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping
    public String displayVenue(@RequestParam(required = false) Integer venueId, Model model) {

        if (venueId == null) {
            model.addAttribute("title", "Venue");
            model.addAttribute("venue", venueRepository.findAll());
        }

        return "venue/index";
    }

}
