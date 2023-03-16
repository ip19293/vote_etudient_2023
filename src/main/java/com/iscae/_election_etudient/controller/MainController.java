package com.iscae._election_etudient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/election/")
public class MainController {
    @GetMapping("public/helo")
    public String homepage(){

        return "index";
    }
}
