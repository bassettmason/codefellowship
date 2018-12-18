package com.bassettmason.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URL;

@Controller
public class ApplicationUserController {
    @Autowired
    private ApplicationUserRepository ApplicationUser Repo;

    @RequestMapping(value="/albums", method= RequestMethod.GET)
    public String index(Model m) {

        m.addAttribute("albums", albumRepo.findAll());
        return "albumIndex";
    }

    @RequestMapping(value="/albums", method=RequestMethod.POST)
    public RedirectView create(
            @RequestParam String title,
            @RequestParam String artist,
            @RequestParam int songCount,
            @RequestParam int length,
            @RequestParam URL imageURL) {
        Album newAlbum = new Album(title, artist, songCount, length, imageURL);
        albumRepo.save(newAlbum);
        return new RedirectView("/albums");
    }
}
