package com.controller;

import com.model.User;
import com.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shreya on 7/18/2017.
 */
@Controller
public class ForgotPasswordController {
    @RequestMapping(value = "/forgotPassword",method = RequestMethod.GET)
    public ModelAndView changePassword(){
        ModelAndView modelAndView=new ModelAndView("forgotpassword");
        return modelAndView;
    }

    @RequestMapping(value = "/checkemail",method = RequestMethod.POST)
    public ModelAndView checkEmail(User user){
        System.out.println(user.getEmail());
        ModelAndView emailExist=new ModelAndView("changepassword");
        ModelAndView emailError=new ModelAndView("errorpassword");
        UserServiceImpl userService=new UserServiceImpl();
        boolean status=userService.emailCheck(user);

        if(status==true)
            return emailExist;
        else
            return emailError;
    }

    @RequestMapping(value = "/changepaswd",method = RequestMethod.POST)
    public ModelAndView changePassword(User user){
        System.out.println(user.getPassword());
        ModelAndView passwordchanged=new ModelAndView("passwordchanged");
        ModelAndView emailError=new ModelAndView("errorpassword");
        UserServiceImpl userService=new UserServiceImpl();
        boolean status=userService.passwordChange(user);

        if(status==true)
            return passwordchanged;
        else
            return emailError;
    }
}
