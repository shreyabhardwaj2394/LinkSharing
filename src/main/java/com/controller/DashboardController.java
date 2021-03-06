package com.controller;

import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.service.SubscriptionServiceImpl;
import com.service.TopicServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Shreya on 7/21/2017.
 */
@Controller
public class DashboardController {

    TopicServiceImpl topicService=new TopicServiceImpl();
    SubscriptionServiceImpl subscriptionService=new SubscriptionServiceImpl();

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    ModelAndView getDashboard(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("dashboard");
        User sessionUser=(User)request.getSession().getAttribute("userDTO");
        modelAndView.addObject("username",sessionUser.getUsername());
        modelAndView.addObject("first",sessionUser.getFirstName());
        modelAndView.addObject("last",sessionUser.getLastName());
        Map<String,Integer> topicmap=topicService.TopicCount(request);
        modelAndView.addObject("TopicCount",topicmap.get("TopicCount"));
        Map<String,Integer> subscriptionmap=subscriptionService.subscriptionCount(request);
        modelAndView.addObject("SubscriptionCount",subscriptionmap.get("SubscriptionCount"));
        modelAndView.addObject("topiclist",topicService.getSubscribedTopics(sessionUser));
        List<Subscription> subscriptionList=subscriptionService.getSubscriptionList(request);
        modelAndView.addObject("subscriptionList",subscriptionList);
        List<Topic> topicList=topicService.getCreatedTopicList(request);
        modelAndView.addObject("createdTopicList",topicList);
        List<Topic> publicTopicList=topicService.getPublicTopics();
        modelAndView.addObject("publicTopics",publicTopicList);
        return modelAndView;
    }
}
