package com.bassettmason.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URL;
import java.nio.file.Path;
import java.util.Date;

@Controller
public class ApplicationUserController {
    @Autowired
    private ApplicationUserRepository userRepo;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model m) {

        m.addAttribute("users", userRepo.findAll());
        return "applicationUserIndex";
    }

    @RequestMapping(value="/users", method=RequestMethod.POST)
    public RedirectView create(
            @RequestParam String userName,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String dateOfBirth,
            @RequestParam String picture,
            @RequestParam String bio) {
        ApplicationUser newUser = new ApplicationUser(userName, password, firstName, lastName, dateOfBirth, picture, bio);
        userRepo.save(newUser);
        return new RedirectView("/");
    }
}
