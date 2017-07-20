package com.controller;

import com.dao.TopicDaoImpl;
import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by Shreya on 7/14/2017.
 */
@Controller
public class LoginController {

    UniqueusernameServiceImpl uniqueusernameService=new UniqueusernameServiceImpl();

    UniqueEmailServiceImpl uniqueEmailService=new UniqueEmailServiceImpl();

    UserServiceImpl userService=new UserServiceImpl();

    TopicServiceImpl topicService=new TopicServiceImpl();

    SubscriptionServiceImpl subscriptionService=new SubscriptionServiceImpl();

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView registeredUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("dashboard");
        ModelAndView error=new ModelAndView("error");

        boolean state=userService.login(user,request,response);

        if(state==true) {
            User sessionUser=(User)request.getSession().getAttribute("userDTO");
            modelAndView.addObject("username",sessionUser.getUsername());
            modelAndView.addObject("first",sessionUser.getFirstName());
            modelAndView.addObject("last",sessionUser.getLastName());
            Map<String,Integer> topicmap=topicService.TopicCount(request);
            modelAndView.addObject("TopicCount",topicmap.get("TopicCount"));
            Map<String,Integer> subscriptionmap=subscriptionService.subscriptionCount(request);
            modelAndView.addObject("SubscriptionCount",subscriptionmap.get("SubscriptionCount"));
            modelAndView.addObject("topiclist",topicService.getSubscribedTopics(user));
            List<Subscription> subscriptionList=subscriptionService.getSubscriptionList(request);
            modelAndView.addObject("subscriptionList",subscriptionList);
            List<Topic> topicList=topicService.getCreatedTopicList(request);
            modelAndView.addObject("createdTopicList",topicList);
            return modelAndView;
        }
        else
            return error;
    }


    @RequestMapping(value = "/uniqueusername",method = RequestMethod.POST)
    public @ResponseBody
    String checkuUername(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
       return  uniqueusernameService.checkavailability(request.getParameter("val"));
    }

    @RequestMapping(value = "/uniqueEmail",method = RequestMethod.POST)
    public @ResponseBody
    String checkEmail(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
        //System.out.println("mail entered:"+request.getParameter("val"));
        return  uniqueEmailService.checkavailability(request.getParameter("val"));
    }
}
