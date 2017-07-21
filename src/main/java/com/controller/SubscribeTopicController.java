package com.controller;

import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.service.SubscriptionServiceImpl;
import com.service.TopicServiceImpl;
import com.utils.enums.Seriousness;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Shreya on 7/21/2017.
 */
@Controller
public class SubscribeTopicController {

    SubscriptionServiceImpl subscriptionService=new SubscriptionServiceImpl();
    TopicServiceImpl topicService=new TopicServiceImpl();
   @RequestMapping(value = "/subscribeTopic/{topicId}")
    public ModelAndView subscribeTopic(@PathVariable Integer topicId
                                       , HttpServletRequest request) {

       Seriousness seriousness= Seriousness.valueOf(request.getParameter("seriousness"));

       System.out.println("s:"+seriousness);
       ModelAndView subscribed = new ModelAndView("dashboard");
       ModelAndView error = new ModelAndView("error");
       User userDTO = (User) request.getSession().getAttribute("userDTO");
       Topic topic=topicService.getTopic(topicId);
       String topicName=topic.getName();
       if (userDTO != null) {
           boolean status = subscriptionService.saveSubscription(topicId, userDTO, seriousness);
           if (status == true) {
               subscribed.addObject("topicName",topicName);
               User sessionUser=(User)request.getSession().getAttribute("userDTO");
               subscribed.addObject("username",sessionUser.getUsername());
               subscribed.addObject("first",sessionUser.getFirstName());
               subscribed.addObject("last",sessionUser.getLastName());
               Map<String,Integer> topicmap=topicService.TopicCount(request);
               subscribed.addObject("TopicCount",topicmap.get("TopicCount"));
               Map<String,Integer> subscriptionmap=subscriptionService.subscriptionCount(request);
               subscribed.addObject("SubscriptionCount",subscriptionmap.get("SubscriptionCount"));
               subscribed.addObject("topiclist",topicService.getSubscribedTopics(sessionUser));
               List<Subscription> subscriptionList=subscriptionService.getSubscriptionList(request);
               subscribed.addObject("subscriptionList",subscriptionList);
               List<Topic> topicList=topicService.getCreatedTopicList(request);
               subscribed.addObject("createdTopicList",topicList);


               List<Topic> publicTopicList=topicService.getPublicTopics();
               subscribed.addObject("publicTopics",publicTopicList);
               return subscribed;
           }
           else
               return error;
       }
       else
           return error;
   }



}
