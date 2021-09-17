package com.tanveer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
//        try {
//            Customer customer=new Customer();
//        } catch (IlligalArgumentException e) {
//            e.printStackTrace();
//        }

        return "index";
    }
}
