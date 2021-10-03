package org.launchcode.Play4All.Controllers;


import org.launchcode.Play4All.data.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("venue")
public class VenueController {

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping
    public String displayAllVenues(Model model) {
        model.addAttribute("venues", venueRepository.findAll());
        return "venue/index";
    }

}
