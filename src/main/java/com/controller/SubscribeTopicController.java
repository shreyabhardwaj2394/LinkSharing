package com.controller;

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

/**
 * Created by Shreya on 7/21/2017.
 */
@Controller
public class SubscribeTopicController {

    SubscriptionServiceImpl subscriptionService=new SubscriptionServiceImpl();
    TopicServiceImpl topicService=new TopicServiceImpl();
   @RequestMapping(value = "/subscribeTopic/{topicId}")
    public ModelAndView subscribeTopic(@PathVariable Integer topicId,
                                       @RequestParam(value = "seriousness", required = true) Seriousness seriousness, HttpServletRequest request) {
       ModelAndView subscribed = new ModelAndView("topicShow");
       ModelAndView error = new ModelAndView("error");
       User userDTO = (User) request.getSession().getAttribute("userDTO");
       Topic topic=topicService.getTopic(topicId);
       String topicName=topic.getName();
       if (userDTO != null) {
           boolean status = subscriptionService.saveSubscription(topicId, userDTO, seriousness);
           if (status == true) {
               subscribed.addObject("first",userDTO.getFirstName());
               subscribed.addObject("topicName",topicName);
               return subscribed;
           }
           else
               return error;
       }
       else
           return error;
   }

}
