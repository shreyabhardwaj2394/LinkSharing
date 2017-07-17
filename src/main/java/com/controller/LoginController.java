package com.controller;

import com.model.User;
import com.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shreya on 7/14/2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute User user){
        ModelAndView modelAndView=new ModelAndView("dashboard");
        ModelAndView modelAndView_fail=new ModelAndView("index");
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        UserServiceImpl userService=new UserServiceImpl();
        boolean state=userService.login(user);

        System.out.println(state);

        if(state==true)
            return modelAndView;
        else
            return modelAndView_fail;
    }

}
