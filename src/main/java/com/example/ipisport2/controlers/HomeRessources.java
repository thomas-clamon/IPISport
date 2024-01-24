package com.example.ipisport2.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Home")
public class HomeRessources {

    @GetMapping("Hello")
    public String hello(){
        return "bonjour";
    }
}
