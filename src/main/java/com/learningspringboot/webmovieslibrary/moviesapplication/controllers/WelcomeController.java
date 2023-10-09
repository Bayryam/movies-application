package com.learningspringboot.webmovieslibrary.moviesapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController
{
    @GetMapping("welcome")
    @ResponseBody
    public String goToWelcomePage(){
        return "This is the Welcome page!";
    }

}
