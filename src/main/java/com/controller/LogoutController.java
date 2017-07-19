package com.controller;

import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shreya on 7/19/2017.
 */
@Controller
public class LogoutController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("index");
        userService.logout(request,response);
        return  modelAndView;
    }
}
