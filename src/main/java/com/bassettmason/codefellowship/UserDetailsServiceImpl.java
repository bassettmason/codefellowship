package com.bassettmason.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ApplicationUserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<ApplicationUser> appUser = this.userRepo.findByUsername(userName);
        if (appUser == null) {
            System.out.println("User Not Found" + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in database");
        }
        System.out.println("Found user: " + appUser);
        return appUser.get();
    }
}
