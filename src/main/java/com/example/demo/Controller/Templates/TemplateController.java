package com.example.demo.Controller.Templates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {
    @GetMapping("login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("Estates")
    public String getEstates(){
        return "Estates";
    }
}