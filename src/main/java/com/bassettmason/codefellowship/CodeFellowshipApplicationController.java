//package com.bassettmason.codefellowship;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.view.RedirectView;
//
//@Controller
//public class CodeFellowshipApplicationController {
//
//
//    @RequestMapping("/")
//    public RedirectView homeRedirect() {
//        return new RedirectView("/users");
//    }
//    @RequestMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
//    @RequestMapping("/hello/{pineapple}/{fromPerson}")
//    public String helloToYou(@PathVariable(name="pineapple") String myName,
//                             @PathVariable String fromPerson,
//                             Model model) {
//        model.addAttribute("myName", myName);
//        return "potato";
//    }
//}
