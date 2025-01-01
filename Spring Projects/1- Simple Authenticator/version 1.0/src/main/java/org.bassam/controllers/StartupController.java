package org.bassam.controllers;

import org.bassam.UserData;
import org.bassam.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StartupController {
    @RequestMapping("/")
    public String startUpApp(){
        UserData.members.put("john@gmail.com",new String[]{"John", "Doe", "Aa!12345"});
        return "startup";
    }

    @RequestMapping("/login")
    public String goToLoginPage(){
        return "login";
    }
    @RequestMapping("/signup")
    public String goToSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
}
