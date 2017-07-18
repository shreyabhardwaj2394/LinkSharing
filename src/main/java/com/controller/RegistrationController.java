package com.controller;

import com.dao.TopicDaoImpl;
import com.model.User;
import com.service.UserServiceImpl;
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


/**
 * Created by Shreya on 7/11/2017.
 */
@Controller

public class RegistrationController {

    TopicDaoImpl topicDao=new TopicDaoImpl();

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute User user,@RequestParam CommonsMultipartFile file,
                                     HttpServletRequest request, HttpServletResponse response){
        String username=user.getUsername();
        ModelAndView modelAndView=new ModelAndView("dashboard");
        modelAndView.addObject("username",username);
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());

        byte[] photo=null;
        if(!file.isEmpty())
            photo=file.getBytes();

        //user.setPhoto(photo);

        System.out.println("List is:");
        List list=topicDao.getSubscribedTopics(user);
        ListIterator itr=list.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        modelAndView.addObject("topiclist",topicDao.getSubscribedTopics(user));


        UserServiceImpl userService=new UserServiceImpl();
        userService.register(user,request,response,photo);
        System.out.println(request.getSession().getAttribute("username"));
        return modelAndView;
    }

}
