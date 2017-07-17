package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Shreya on 7/11/2017.
 */
@Controller

public class RegistrationController {

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute User user){
        String firstName=user.getFirstName();
        ModelAndView modelAndView=new ModelAndView("dashboard");
        modelAndView.addObject("firstName",firstName);
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        UserService userService=new UserService();
        userService.register(user);
        return modelAndView;
    }

}
