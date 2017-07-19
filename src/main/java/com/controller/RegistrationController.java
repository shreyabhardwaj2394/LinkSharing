package com.controller;

import com.dao.TopicDaoImpl;
import com.model.User;
import com.service.TopicServiceImpl;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


/**
 * Created by Shreya on 7/11/2017.
 */
@Controller

public class RegistrationController {


    //TopicDaoImpl topicDao=new TopicDaoImpl();

    UserServiceImpl userService=new UserServiceImpl();

    TopicServiceImpl topicService=new TopicServiceImpl();

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute User user,@RequestParam CommonsMultipartFile file,
                                     HttpServletRequest request, HttpServletResponse response){
        String username=user.getUsername();
        ModelAndView modelAndView=new ModelAndView("dashboard");

        byte[] photo=null;
        if(!file.isEmpty())
            photo=file.getBytes();



        userService.register(user,request,response,photo);

        User sessionUser=(User)request.getSession().getAttribute("userDTO");
        modelAndView.addObject("username",sessionUser.getUsername());
        modelAndView.addObject("first",sessionUser.getFirstName());
        modelAndView.addObject("last",sessionUser.getLastName());
        Map<String,Integer> map=topicService.subscriptionAndTopicCount(request);
        modelAndView.addObject("TopicCount",map.get("TopicCount"));
        //modelAndView.addObject("topiclist",topicDao.getSubscribedTopics(user));
        return modelAndView;
    }

}
