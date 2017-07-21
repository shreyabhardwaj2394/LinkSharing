package com.controller;

import com.model.Resource;
import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.service.ResourceServiceImpl;
import com.service.SubscriptionServiceImpl;
import com.service.TopicServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Shreya on 7/21/2017.
 */
@Controller
public class FallBackController {

    TopicServiceImpl topicService=new TopicServiceImpl();
    SubscriptionServiceImpl subscriptionService=new SubscriptionServiceImpl();
    ResourceServiceImpl resourceService=new ResourceServiceImpl();

    @RequestMapping("*")
    public ModelAndView fallbackMethod(HttpServletRequest request, HttpServletResponse response) {
        User sessionUser=(User)request.getSession().getAttribute("userDTO");
        ModelAndView index=new ModelAndView("index");
        ModelAndView dasboard=new ModelAndView("dashboard");
        if(sessionUser!=null){
            dasboard.addObject("username",sessionUser.getUsername());
            dasboard.addObject("first",sessionUser.getFirstName());
            dasboard.addObject("last",sessionUser.getLastName());
            Map<String,Integer> topicmap=topicService.TopicCount(request);
            dasboard.addObject("TopicCount",topicmap.get("TopicCount"));
            Map<String,Integer> subscriptionmap=subscriptionService.subscriptionCount(request);
            dasboard.addObject("SubscriptionCount",subscriptionmap.get("SubscriptionCount"));
            List<Subscription> subscriptionList=subscriptionService.getSubscriptionList(request);
            dasboard.addObject("subscriptionList",subscriptionList);
            dasboard.addObject("topiclist",topicService.getSubscribedTopics(sessionUser));
            List<Topic> topicList=topicService.getCreatedTopicList(request);
            dasboard.addObject("createdTopicList",topicList);
            List<Topic> publicTopicList=topicService.getPublicTopics();
            dasboard.addObject("publicTopics",publicTopicList);
            return dasboard;
        }
        else{
            List<Resource> resourceList=resourceService.getPublic();
            index.addObject("resourceList",resourceList);
            return index;
        }
        
    }
}
