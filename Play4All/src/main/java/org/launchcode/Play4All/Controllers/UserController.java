package org.launchcode.Play4All.Controllers;

import org.launchcode.Play4All.data.UserRepository;
import org.launchcode.Play4All.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String displayUserIndex(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "user/index";
    }

    @GetMapping("details")
    public String displayUserDetails(@RequestParam Integer userId, Model model) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        model.addAttribute("user", user);

        return "user/details";
    }
}
