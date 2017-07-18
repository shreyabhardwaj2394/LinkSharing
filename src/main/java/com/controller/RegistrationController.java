package com.controller;

import com.model.User;
import com.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Shreya on 7/11/2017.
 */
@Controller

public class RegistrationController {

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response){
        String username=user.getUsername();
        ModelAndView modelAndView=new ModelAndView("dashboard");
        modelAndView.addObject("username",username);
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        UserServiceImpl userService=new UserServiceImpl();
        userService.register(user,request,response);
        System.out.println(request.getSession().getAttribute("username"));
        return modelAndView;
    }

}
