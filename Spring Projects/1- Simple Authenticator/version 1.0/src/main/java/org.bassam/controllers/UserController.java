package org.bassam.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.bassam.UserData;
import org.bassam.Validator;
import org.bassam.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/signup")
    public String getAndCheckSignupFormData(@ModelAttribute("user") User user
                                                , Validator validator
                                                , Model model){

        boolean firstName = validator.isValidName(user.getFirstName());
        boolean lastName = validator.isValidName(user.getLastName());
        boolean email = validator.isValidEmail(user.getEmail());
        boolean pass = validator.isValidPassword(user.getPassword());

        if (validator.isEmailExist(user.getEmail())){
            model.addAttribute("errorMsg","Email Exist already");
            return "error-page-msg";
        }
        else if ((pass && firstName && lastName && email)){
            UserData.members.put(user.getEmail()
                                , new String[]{user.getFirstName(), user.getLastName(), user.getPassword()});
            return "login";
        }
        else return"signup-form-instructions";
    }

    @RequestMapping("/login")
    public String getAndCheckLoginData(@RequestParam("email") String email
                                        , @RequestParam("password") String pass
                                        , Model model
                                        , Validator validator
                                        , HttpServletResponse response) throws Exception{
        if (!validator.isEmailExist(email)){
            model.addAttribute("errorMsg","Email Not Exist");
            return "error-page-msg";
        }
        else if (!validator.isPasswordCorrect(email,pass)){
            model.addAttribute("errorMsg","Password Incorrect");
            return "error-page-msg";
        }
        else return "forward:/user/home";
    }

    @RequestMapping("/home")
    public String goHomeToShowMembers(Model model){
        model.addAttribute("membersData",UserData.members.entrySet());
        return "home";
    }

}
