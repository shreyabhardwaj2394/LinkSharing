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
 * Created by Shreya on 7/14/2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("dashboard");
        String username=user.getUsername();
        System.out.println("username"+username);
        modelAndView.addObject("username",username);
        ModelAndView modelAndView_fail=new ModelAndView("index");

        UserServiceImpl userService=new UserServiceImpl();
        boolean state=userService.login(user);

        System.out.println(state);

        if(state==true) {
            request.getSession().setAttribute("userDTO",user);
            return modelAndView;
        }
        else
            return modelAndView_fail;
    }

}
