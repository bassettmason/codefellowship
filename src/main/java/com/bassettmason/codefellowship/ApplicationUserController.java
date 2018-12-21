package com.bassettmason.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
public class ApplicationUserController {
    @Autowired
    private ApplicationUserRepository userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authManager;
//path to home index page
    @GetMapping("/")
    public String index() {
        return "index";
    }
//not quite sure maybe login after sign up
    @GetMapping("/applicationUserIndex")
    public String showSignUpPage(Principal p, Model m) {
        System.out.println(p);
        ApplicationUser u = new ApplicationUser();
        return "applicationUserIndex";
    }
//sign up and save new user path to that specific user details
    @PostMapping("/applicationUserIndex")
    public RedirectView applicationUserIndex(
            @RequestParam String userName,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String dateOfBirth,
            @RequestParam String picture,
            @RequestParam String bio) {

        ApplicationUser newUser = new ApplicationUser(userName, bCryptPasswordEncoder.encode(password), firstName, lastName, dateOfBirth, picture, bio);
        newUser = userRepo.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/userDetail");
    }
//login path to userdetail
    @GetMapping("/login")
    public String login(){

        return ("userDetail");
    }
//get logged in user detail
    @GetMapping("/userDetail")
    public String userDetail(Principal p, Model m) {
        ApplicationUser currentUser = (ApplicationUser) p;
        System.out.println(p);
        m.addAttribute("user", p);
        return "userDetail";
    }

//users path list all users
@GetMapping()    public String users(Model m) {

        m.addAttribute("users", userRepo.findAll());

        return ("users");
    }


//get current login user
    @RequestMapping(value="/userDetail", method= RequestMethod.GET)
    public String userShow(@RequestParam long id, Model m) {
        Optional<ApplicationUser> u = userRepo.findById(id);
        if(u.isPresent()) {
            m.addAttribute("users", u.get());
            return "userDetail";
        } else {

            throw new ResourceNotFoundException();
        }

    }

    @GetMapping("/userDetail")
    public String getUser(Principal p, Model m) {
        m.addAttribute("user", ((UsernamePasswordAuthenticationToken) p).getPrincipal());
        return "userDetail";
    }



}
@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException extends RuntimeException {
    
}