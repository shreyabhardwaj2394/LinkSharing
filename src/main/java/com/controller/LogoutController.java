package com.controller;

import com.model.Resource;
import com.model.Topic;
import com.model.User;
import com.service.ResourceServiceImpl;
import com.service.TopicServiceImpl;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Shreya on 7/19/2017.
 */
@Controller
public class LogoutController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    TopicServiceImpl topicService;

    @Autowired
    ResourceServiceImpl resourceService;

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("index");
        userService.logout(request,response);
        List<Resource> resourceList=resourceService.getPublic();
        modelAndView.addObject("resourceList",resourceList);
        return  modelAndView;
    }
}
